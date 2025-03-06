package NotSoSimple;

import Simple.SimpleClient;

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
 * NotSoSimple.NotSoSimpleServer
 * Extension of NotSoSimple.NotSoSimpleClient, for acting as a server
 *
 * Messaging works as follows:
 *
 *           Client send message -> Server
 *           Server sends received message -> All connected clients
 *
 * Data is packaged as:
 * name=data.NAME, chat=data.CODE, req=data.REQ
 */

public class NotSoSimpleServer extends NotSoSimpleClient {

    public ServerSocket serverSocket;
    public ArrayList<ClientHandler> clients;
    public groupList groups = new groupList();

    public NotSoSimpleServer(int port) {
        super(port, "Server");

        clients = new ArrayList<>();
    }

    @Override
    public void connect() {
        /* Method to attempt to start server */

        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Connecting to server [" + e.getMessage() + "]", true);
        }

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

    public void resendMessage(String message) {
        /* Method for sending the already packaged message back to all clients */

        for (ClientHandler client : clients) {
            if (!client.closed) {
                client.sendToClient(message);
            }
        }

        //addPackagedMessage(message);
    }

    public void createRoom(ClientHandler client) {
        /* Method for creating a new chat room */
        group g = groups.createGroup();
        String chatCode = g.getGroupCode();

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
    }
}
