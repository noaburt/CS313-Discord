import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/*
 * SimpleServer
 * Implementation of JPanel class, extension of SimpleClient, for acting as a server
 *
 * Messaging works as follows:
 *
 *           Client send message -> Server
 *           Server sends received message -> All connected clients
 *
 * This class is instantiated and passed into SimpleGui with the JPanel content.
 * SimpleServer utilises most of SimpleClient, with some methods overridden.
 * The ClientHandler class contained within is used for continuously checking for client messages.
 * Array list clients contains all ClientHandlers being used by server
 *
 * NOTE - OLD HANDLERS ARE NEVER REMOVED, NEED TO FIX THIS AT SOME POINT
 *
 * Actions of this Class:
 *
 * Creating gui JPanel - addTextBoxes(), makePanel()
 * Starting the server, listen for clients - connect()
 * Recieving / listening for messages - connect(), clients, ClientHandler
 * Sending messages - addMessage(), sendMessage(), resendMessage()
 * Stopping server - shutdown()
 *
 */
public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;
    public ArrayList<ClientHandler> clients;
    public JPanel messagePanel; // Panel to hold messages

    public SimpleServer(int port) {
        super(port, "Server");
        clients = new ArrayList<>();
    }

    @Override
    public void addTextBoxes() {
        /* Method for adding only required text boxes to server window */

        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(messagePanel);
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
            addMessage("Creating server at port " + serverPort);
            serverSocket = new ServerSocket(serverPort);
            addMessage("Server active...\n");
        } catch (IOException e) {
            catchMessage("Connecting to server [" + e.getMessage() + "]", true);
        }

        enableButtons();

        try {
            while (true) {
                clients.add(new ClientHandler(serverSocket.accept()));
                clients.get(clients.size() - 1).start();
            }
        } catch (IOException e) {
            catchMessage("Client socket accept", true);
        }
    }

    /* Thread class for handling new clients connecting to server, runs thread to continuously check messages */
    public class ClientHandler extends Thread {
        private final Socket clientSocket;
        private DataInputStream thisInput;
        private DataOutputStream thisOutput;

        public boolean closed;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            this.closed = false;
        }

        public void run() {
            /* First message is always name etc */
            try {
                thisInput = new DataInputStream(this.clientSocket.getInputStream());

                /* Client data in form {;name;} -------------------------------------------- MIGHT NOT NEED KEEP FOR NOW */
                String readClientData = thisInput.readUTF();
                String clientName = readClientData.split(";")[1];

                thisOutput = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                catchMessage("Starting data stream", true);
                shutdownClient();
            }

            String inputLine;

            /* Check for messages from client until shutdown */
            try {
                while (true) {
                    /* Read input and resend */
                    inputLine = thisInput.readUTF();

                    if (inputLine.startsWith("file:")) {
                        /* Method to handle file upload from a client */
                        try {
                            String[] parts = inputLine.split(":");
                            String fileName = parts[1];
                            long fileLength = Long.parseLong(parts[2]);

                            // Create uploads directory if it doesn't exist
                            new File("uploads").mkdirs();

                            // Received file creation
                            File file = new File("uploads/" + fileName);
                            FileOutputStream fileOutputStream = new FileOutputStream(file);
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            long remaining = fileLength;

                            // Read and save the file
                            while (remaining > 0 && (bytesRead = thisInput.read(buffer, 0, (int) Math.min(buffer.length, remaining))) != -1) {
                                fileOutputStream.write(buffer, 0, bytesRead);
                                remaining -= bytesRead;
                            }

                            fileOutputStream.close();
                            addMessage("Received file: " + fileName);

                            // Notify all clients about the uploaded file
                            resendMessage("A file has been uploaded: " + fileName);
                        } catch (IOException ex) {
                            catchMessage("Error receiving file: " + ex.getMessage(), true);
                        }
                    } else {
                        /* Resend message to all clients */
                        resendMessage(inputLine);
                    }

                    if (inputLine.split(":")[1].equals(" has left the server\n")) {
                        this.shutdownClient();
                    }
                }
            } catch (IOException e) {
                catchMessage("Connection closed", false);
                shutdownClient();
            }
        }

        public void shutdownClient() {
            /* Shutdown this specific client handler, since client has left server */
            if (thisInput != null) {
                try {
                    thisInput.close();
                } catch (IOException e) {
                    catchMessage("Closing client input stream", true);
                }
            }

            if (thisOutput != null) {
                try {
                    thisOutput.close();
                } catch (IOException e) {
                    catchMessage("Closing client output stream", true);
                }
            }

            this.closed = true;
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
        /* Method for sending a message from the server, with server name */
        try {
            String sendMsg = clientName + ": " + message;

            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(sendMsg);
                }
            }

            addMessage(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            catchMessage("Sending message from server [" + e.getMessage() + "]", true);
        }
    }

    public void resendMessage(String message) {
        /* Method for sending a message to all clients */
        try {
            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(message);
                }
            }

            addMessage(message);
        } catch (IOException e) {
            addMessage("Error: Failed to resend message '" + message + "'\n(" + e.getMessage() + ")");
            catchMessage("Resending message to clients [" + e.getMessage() + "]", true);
        }
    }

    @Override
    public void shutdown() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                catchMessage("Closing server input stream", true);
            }
        }

        for (ClientHandler client : clients) {
            client.shutdownClient();
        }

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                catchMessage("Closing server socket", true);
            }
        }

        addMessage("Server stopped\n");
        disableButtons();
    }

    // New method to display messages in messagePanel
    public void addMessage(String message) {
        JLabel messageLabel = new JLabel(message);
        messagePanel.add(messageLabel);
        messagePanel.revalidate();
        messagePanel.repaint();
    }
}
