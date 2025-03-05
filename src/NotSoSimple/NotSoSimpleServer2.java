package NotSoSimple;
import Simple.*;

import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class NotSoSimpleServer2 extends SimpleClient {


    public ServerSocket serverSocket;
    public ArrayList<ClientHandler> clients;
    public groupList groups = new groupList();

    public NotSoSimpleServer2(int port) {
        super(port, "Server");

        clients = new ArrayList<>();
    }


    @Override
    public void connect() {
        /* Method to attempt to start server */

        try {
            serverSocket = new ServerSocket(serverPort);
        } catch (Exception e) {
            System.out.println("Server could not be started");
        }


        try {
            while (true) {
                clients.add(new ClientHandler(serverSocket.accept()));
                clients.getLast().start();
            }
        } catch (Exception e) {
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

                /* Client data in NotSoSimple.form {;name;} -------------------------------------------- MIGHT NOT NEED KEEP FOR NOW */
                String readClientData = thisInput.readUTF();
                String clientName = readClientData.split(";")[1];

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
                    /* Resend message to all clients */
                    resendMessage(inputLine);

                }
            } catch (IOException e) {
                //e.printStackTrace();
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
    public void sendMessage(String message) {
        /* Method for sending a message from the server, with server name */

        try {
            String sendMsg = clientName + ": " + message;

            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(message);
                }
            }

            messageArea.append(sendMsg + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
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

        } catch (IOException e) {
            addMessage("Error: Failed to resend message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Resending message to clients [" + e.getMessage() + "]", true);
        }
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

    }

    public String reqServer(){
        group g = groups.createGroup();
        return g.getGroupCode();
    }
}
