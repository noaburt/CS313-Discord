import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;

    public SimpleServer(int port) {
        super(port, "Server");

    }

    @Override
    public void addTextBoxes() {
        /* Method for adding only required text boxes to server window */

        messageArea = new JTextArea(10, 20);
        messageArea.setEditable(false);

        add(new JScrollPane(messageArea));
    }

    public void sendMessage(String message, boolean ext) {
        /* Method for sending a message to the server, including name and displaying on gui */

        try {
            String sendMsg = (ext ? "" : clientName + ": ") + message;
            output.writeUTF(sendMsg);
            addMessage(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    @Override
    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Shutdown Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage("Server shutting down...", false);
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
                            output = new DataOutputStream(clientSocket.getOutputStream());
                            input = new DataInputStream(clientSocket.getInputStream());

                            /* Welcome client to server */
                            sendMessage("A client has joined, welcome!\n", false);

                            /* SwingWorker used for updating input / output stream */
                            createMessageWorker();

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
                output.close();
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

    @Override
    public void createMessageWorker() {
        /* Method for creating a message worker for reading messages from server */

        messageWorker = new ReadMessageWorker(input, new ReadMessageWorker.MessageListener() {
            @Override
            public void didRecieveMessage(String message) {
                sendMessage(message, true);
            }
        });

        messageWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(messageWorker.getState());
                if (messageWorker.getState() == SwingWorker.StateValue.DONE) {
                    try {
                        messageWorker.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }

                    /* Shutdown when client ceases input stream */
                    // THIS IS A TERRIBLE WAY TO DO THIS, CHEATING
                    if (!clientName.equals("Server")) { shutdown(); }
                }
            }
        });

        messageWorker.execute();
    }

}
