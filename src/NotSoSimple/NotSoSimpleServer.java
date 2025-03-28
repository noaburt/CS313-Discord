package NotSoSimple;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

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
    public userList users = new userList();
    public groupList groups = new groupList();

    public NotSoSimpleServer(int port) {
        super(port, "Server");

        clients = new ArrayList<>();
        groups.addGroup(new group("GLOBAL"));
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

                    //System.out.println("Server heard: " + inputLine);
                    /* Strip data from received */
                    HashMap<String, String> receivedData = new HashMap<>();
                    unpackageData(inputLine, receivedData);

                    commonconstants.reqCodes request = commonconstants.reqCodes.valueOf(receivedData.get("req"));
                    group G;
                    HashMap<String, String> data;
                    String sendMsg;
                    user U;
                    String toShow;

                    switch (request) {
                        case commonconstants.reqCodes.NEW_CHAT:
                            while(true){
                                if(!groups.setListLock(commonconstants.t)){
                                    continue;
                                }
                                break;
                            }
                            /* Client has requested new chat */
                            String code;
                            if(receivedData.get("status").equals("BREAKER")) {
                                code = createRoomBreaker();
                            }else{
                                code = createRoom();
                            }
                            data = makeData(clientName,code,commonconstants.reqCodes.NEW_CHAT_CONF,"","");
                            sendMsg = packageData("", data);
                            sendToClient(sendMsg);
                            groups.setListLock(commonconstants.f);

                            break;

                        case commonconstants.reqCodes.LEAVE:
                            /* Resend goodbye message and leave chatroom */
                            resendMessage(inputLine);
                            data = new HashMap<>();
                            toShow = unpackageData(inputLine, data);
                            groups.getGroup(receivedData.get("code")).addMessage(data.get("name") + ": " + toShow);
                            break;

                        case commonconstants.reqCodes.DISCONNECT:
                            /* Leave server and shutdown handler */
                            this.shutdownClient();
                            break;

                        case commonconstants.reqCodes.NONE:
                            /* Resent message to all clients as normal */


                            data = new HashMap<>();
                            toShow = unpackageData(inputLine, data);
                            groups.getGroup(receivedData.get("code")).addMessage(data.get("name") + ": " + toShow);
                            resendMessage(inputLine);
                            break;

                        case commonconstants.reqCodes.NEW_CHAT_CONF, commonconstants.reqCodes.NEW_USER_CONF
                        ,commonconstants.reqCodes.LOGIN_CONF:
                            /* Client is not allowed to do this */
                            throw new IllegalAccessException();

                        case commonconstants.reqCodes.EXISTING_CHAT:
                            G = groups.getGroup(receivedData.get("code"));
                            String chatCode = (G != null) ? receivedData.get("code") : "F";
                            data = makeData(clientName, chatCode, commonconstants.reqCodes.EXISTING_CHAT,"","");
                            sendMsg = packageData("", data);
                            sendToClient(sendMsg);
                            break;

                        case commonconstants.reqCodes.CHAT_HISTORY:
//                            for(user u : users.getUsers()){
//                                System.out.println(u.getName());
//                            }
//                            for(group g:groups.getGroups()){
//                                System.out.println(g.getGroupCode());
//                            }
                            List<String> loggedchats = groups.getGroup(receivedData.get("code")).getMessages();
                            StringBuilder loggedChats = new StringBuilder();
                            for(String s:loggedchats){
                                loggedChats.append(s).append("\n");
                            }
                            data = makeData(clientName, receivedData.get("code"), commonconstants.reqCodes.CHAT_HISTORY,"","");
                            sendMsg = packageData(loggedChats.toString(), data);
                            //System.out.println("Logged chats: " + loggedChats.toString());
                            sendToClient(sendMsg);
                            break;


                        case commonconstants.reqCodes.NEW_USER:
                            while(true){
                                if(!users.setListLock(commonconstants.t)){
                                    continue;
                                }

                                break;
                            }

                            if(createUser(receivedData)){
                                data = makeData(clientName,receivedData.get("code"),commonconstants.reqCodes.NEW_USER_CONF,"VALID","");
                            } else {
                                data = makeData(clientName,receivedData.get("code"),commonconstants.reqCodes.NEW_USER_CONF,"INVALID","");
                            }

                            users.setListLock(commonconstants.f);
                            sendMsg = packageData("", data);
                            sendToClient(sendMsg);
                            break;


                        case commonconstants.reqCodes.LOGIN:
                            U = users.getUser(receivedData.get("status"));
                            if(U == null){
                                data = makeData(clientName,receivedData.get("code"),commonconstants.reqCodes.LOGIN_CONF,"INVALID","");
                                sendMsg = packageData("", data);
                                sendToClient(sendMsg);
                            }else{
                                if(U.getPassword().equals(receivedData.get("password"))){
                                    data = makeData(clientName,receivedData.get("code"),commonconstants.reqCodes.LOGIN_CONF,"VALID","");
                                    sendMsg = packageData("", data);
                                    sendToClient(sendMsg);
                                }else{
                                    data = makeData(clientName,receivedData.get("code"),commonconstants.reqCodes.LOGIN_CONF,"INVALID","");
                                    sendMsg = packageData("", data);
                                    sendToClient(sendMsg);
                                }

                            }
                            break;

                        case FILE_NAME_LEN:
                            receiveFile(inputLine);
                            break;

                    }
                }
            } catch (IOException e) {
                //e.printStackTrace();

                //catchMessage("Client left the server [handler]", false);

            } catch (IllegalAccessException e) {
                //e.printStackTrace();
                catchMessage("Client sent NEW_CHAT_CONF, not allowed", true);

                shutdownClient();
            }
        }

        private void receiveFile(String inputLine){
            /* Method to handle file upload from a client */
            try {
                // Get file details
                String[] fileDetails = unpackageData(inputLine, null).split("///");

                String fileName = fileDetails[0];
                long fileLength = Long.parseLong(fileDetails[1]);

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
                addMessage("You received a file: " + fileName);
            } catch (IOException ex) {
                catchMessage("Error receiving file: " + ex.getMessage(), true);
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
            removeClient(this);
        }
    }

    public void resendMessage(String message) {
        /* Method for sending the already packaged message back to all clients */

        ArrayList<ClientHandler> oldClient = new ArrayList<>(clients); // This fixes concurrentModification exception by making class stateless

        //for (ClientHandler client : clients) {  //broken como thing not static
        for (ClientHandler client : oldClient) {
            if (client.closed) {
                clients.remove(client);
                continue;
            }

            client.sendToClient(message);
        }
    }

    public void removeClient(ClientHandler client) {
        /* A client leaves the server, remove handler */
        clients.remove(client);
    }

    public String createRoom() {
        /* Method for creating a new chat room */
        String created = "F";
        String rCode;
        int tries = 0;
        while(created.equals("F") || tries < 500){
            rCode = groups.bensWonderfulFunction();
            if(groups.getGroup(rCode) == null){
                groups.createGroup(rCode);
                created = rCode;
            }
            tries++;
        }
        return created;
    }

    public String createRoomBreaker() {
        /* Method for creating a new chat room */
        String created = "F";
        if(groups.getGroup("test") == null){
            groups.createGroup("test");
            created = "test";
        }
        return created;
    }

    public synchronized boolean createUser(HashMap<String, String> receivedData){

        boolean created = false;


        if(users.getUser(receivedData.get("status")) == null) {
            users.createUser(receivedData.get("status"), receivedData.get("password"));
            created = true;
        }

        return created;
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
