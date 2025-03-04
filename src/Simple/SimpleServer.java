package Simple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * Simple.SimpleServer
 * Implementation of JPanel class, extension of Simple.SimpleClient, for acting as a server
 *
 * Messaging works as follows:
 *
 *           Client send message -> Server
 *           Server sends received message -> All connected clients
 *
 * This class is instantiated and passed into Simple.SimpleGui with the JPanel content.
 * Simple.SimpleServer utilises most of Simple.SimpleClient, with some methods overridden.
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

    public SimpleServer(int port) {
        super(port, "Server");

        clients = new ArrayList<>();
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
            //checkStartServer();
            addMessage("Creating server at port " + serverPort);

            serverSocket = new ServerSocket(serverPort);

            addMessage("Server active...\n");

        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Connecting to server [" + e.getMessage() + "]", true);
        }

        enableButtons();

        try {
            while (true) {
                clients.add(new ClientHandler(serverSocket.accept()));
                clients.getLast().start();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Client socket accept loop", false);
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
            /* Begin listening for messages */

            try {
                thisInput = new DataInputStream(this.clientSocket.getInputStream());
                thisOutput = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Starting data stream", true);

                shutdownClient();
            }

            String inputLine;

            /* Check for messages from client until shutdown */
            try {
                while (true) {
                    /* Read input and resend */
                    inputLine = thisInput.readUTF();

                    /* Strip data from received */
                    Map<String, String> receivedData = new HashMap<>();
                    unpackageData(inputLine, receivedData);

                    /* Client has requested a new chat room */
                    if (receivedData.get("req").equals(reqCodes.NEW_CHAT.name())) {
                        createRoom(this);

                        /* No message with request, don't resend */
                        continue;
                    }

                    /* Resend message to all clients */
                    resendMessage(inputLine);

                    if (receivedData.get("req").equals(reqCodes.LEAVE.name())) {
                        //System.out.println(clientName + " has left, client handler shutdown");
                        this.shutdownClient();
                    }
                }
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Connection closed", false);

                shutdownClient();
            }
        }

        public void sendToClient(String message) {
            /* Send message to this client, message should be packaged already */

            try {
                thisOutput.writeUTF(message);
            } catch (IOException e) {
                addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

                //e.printStackTrace();
                catchMessage("Sending message from server [" + e.getMessage() + "]", true);
            }
        }

        public void shutdownClient() {
            /* Shutdown this specific client handler, since client has left server */

            if (thisInput != null) {
                try {
                    thisInput.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    catchMessage("Closing client input stream", true);
                }
            }

            if (thisOutput != null) {
                try {
                    thisOutput.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    catchMessage("Closing client output stream", true);
                }
            }

            this.closed = true;
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
        /* Method for sending a message from the server, with server name */

        try {
            Map<String, String> data = new HashMap<String, String>();
            data.put("name", clientName);
            data.put("code", currentChatCode);
            data.put("req", reqCodes.NONE.name());

            String sendMsg = packageData(message, data);

            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(sendMsg);
                }
            }

            messageArea.append(message + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Sending message from server [" + e.getMessage() + "]", true);
        }
    }

    public void resendMessage(String message) {
        /* Method for sending a message to all clients */

        for (ClientHandler client : clients) {
            if (!client.closed) {
                client.sendToClient(message);
            }
        }


        addPackagedMessage(message);
    }

    public void createRoom(ClientHandler client) { //------------------------------------------ PLACEHOLDER
        /* Method for creating a new chat room */
        System.out.println("Creating a new room...");
        String chatCode = "abcdef";

        Map<String, String> data = new HashMap<String, String>();
        data.put("name", clientName);
        data.put("code", chatCode);
        data.put("req", reqCodes.NEW_CHAT_CONF.name());

        String sendMsg = packageData("", data);
        System.out.println(sendMsg);
        client.sendToClient(sendMsg);
    }

    @Override
    public void shutdown() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                //e.printStackTrace();
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
                //e.printStackTrace();
                catchMessage("Closing server socket", true);
            }
        }

        addMessage("Server stopped\n");

        //checkShutdown();
        disableButtons();
    }
}
