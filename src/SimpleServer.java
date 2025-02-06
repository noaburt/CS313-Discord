import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;

    public ArrayList<DataOutputStream> output;

    public SimpleServer(int port) {
        super(port, "Server");

        output = new ArrayList<>();
    }

    @Override
    public void addTextBoxes() {
        /* Method for adding only required text boxes to server window */

        messageArea = new JTextArea(10, 20);
        messageArea.setEditable(false);

        /* Keep scroll always showing the newest messages */
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        add(scrollPane);
    }

    @Override
    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Shutdown Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage("shutting down...");
                shutdown();
            }
        });

        connectButton = new JButton("Start server");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    public void run() {
                        connect();
                    }
                }).start();
            }
        });

        panel.add(shutdownButton);
        panel.add(connectButton);
        return panel;
    }

    @Override
    public void connect() {
        /* Method to attempt to start server */

        try {
            checkStartServer();
            addMessage("Creating server at port " + serverPort);

            serverSocket = new ServerSocket(serverPort);

            addMessage("Server active...\n");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                new Thread(new Runnable() {
                    public void run() {
                        try {
                            output.add(new DataOutputStream(clientSocket.getOutputStream()));
                            input = new DataInputStream(clientSocket.getInputStream());

                            while (true) {
                                String inputLine = input.readUTF();

                                /* Resend message to all clients */
                                resendMessage(inputLine);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void checkStartServer() {
        /* Check if a server is already started, make button inactive */

        if (!EventQueue.isDispatchThread()) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    checkStartServer();
                }
            });
            return;
        }

        enableButtons();
    }

    @Override
    public void disableButtons() {
        /* Method to enable / disable buttons when connection ended */

        connectButton.setEnabled(true);
        shutdownButton.setEnabled(false);
    }

    @Override
    public void enableButtons() {
        /* Method to enable / disable buttons when connection started */

        connectButton.setEnabled(false);
        shutdownButton.setEnabled(true);
    }

    @Override
    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        try {
            String sendMsg = clientName + ": " + message;

            for (DataOutputStream eachOutput : output) {
                eachOutput.writeUTF(sendMsg);
            }

            messageArea.append(sendMsg + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    public void resendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        try {
            for (DataOutputStream eachOutput : output) {
                eachOutput.writeUTF(message);
            }

            messageArea.append(message + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (output != null) {
            try {
                for (DataOutputStream eachOutput : output) {
                    eachOutput.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        addMessage("Server stopped\n");
        checkShutdown();
    }
}
