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
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;

    public LinkedHashMap<String, DataOutputStream> output;

    public SimpleServer(int port) {
        super(port, "Server");

        output = new LinkedHashMap<>();
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
                            input = new DataInputStream(clientSocket.getInputStream());

                            /* Client data in form {;name;} */
                            String readClientData = input.readUTF();
                            String clientName = readClientData.split(";")[1];

                            System.out.println(clientName);

                            output.put(clientName, new DataOutputStream(clientSocket.getOutputStream())); // GET NAME SOMEHOW? ----------------------------------------------------------

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

            for (Map.Entry<String, DataOutputStream> eachOutput : output.entrySet()) {
                eachOutput.getValue().writeUTF(sendMsg);
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
            /* If client leaves server, remove from output set */
            System.out.println(message.split(":")[1]);

            if (message.split(":")[1].equals(" has left the server\n")) {
                System.out.println(message.split(":")[0] + " has left");
                output.remove(message.split(":")[0]);
            }

            for (Map.Entry<String, DataOutputStream> eachOutput : output.entrySet()) {
                System.out.println("Sending message to " + eachOutput.getKey());
                eachOutput.getValue().writeUTF(message);
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
                for (Map.Entry<String, DataOutputStream> eachOutput : output.entrySet()) {
                    eachOutput.getValue().close();
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
