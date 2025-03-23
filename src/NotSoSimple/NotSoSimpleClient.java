package NotSoSimple;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/*
 * NotSoSimple.NotSoSimpleClient
 * Class for acting as a client / server
 *
 * Data is packaged as:
 * name=data.NAME, chat=data.CODE, req=data.REQ
 */

public class NotSoSimpleClient {
    /* Class for all clients to be used */

    public int serverPort;

    public String clientName;
    private String currentRoomCode;

    public Socket clientSocket;
    public boolean connected;

    public DataInputStream input;
    private DataOutputStream output;

    public JTextArea messageArea;
    public JTextField messageField;
    public JButton shutdownButton;
    public JButton connectButton;

    private final String separator;
    private final String openCode;
    private final String closeCode;
    private final int codesLen;

    public boolean isListening;

    public NotSoSimpleClient(int port, String thisName) {
        /* Setup window when client instance is created */

        serverPort = port;
        clientName = thisName;
        currentRoomCode = "";
        connected = false;
        isListening = false;

        messageArea = new JTextArea();
        messageField = new JTextField();

        /* This separates the data no matter what */
        separator = ",-=;#";

        /* This stops the user being able to type a message to close the message early (I HOPE) I HATE MYSELF THIS IS A PAIN */
        openCode = "['*{!";
        closeCode = "!}*']";

        codesLen = openCode.length(); // All same length
    }

    public void catchMessage(String message, boolean error) {
        /* Nice way of clarifying errors from try-catch blocks */

        System.out.println((error ? "Error: " : "Caught: ") + message);
    }

    /* Add message FROM someone */
    public void addPackagedMessage(String inputLine) {
        /* Method for appending a message to the display, not for sending */
        HashMap<String, String> data = new HashMap<>();
        String toShow = unpackageData(inputLine, data);
        System.out.println(inputLine);

        if (commonconstants.reqCodes.valueOf(data.get("req")) == commonconstants.reqCodes.NEW_CHAT_CONF) {
            /* Server has confirmed new chat */
            this.currentRoomCode = data.get("code");

            System.out.println("Client joined new chat room: " + this.currentRoomCode);

            return;
        }

        if(commonconstants.reqCodes.valueOf(data.get("req")) == commonconstants.reqCodes.EXISTING_CHAT) {
            this.currentRoomCode = data.get("code");
            return;
        }
        // server has returned response to creating a user
        if(commonconstants.reqCodes.valueOf(data.get("req")) == commonconstants.reqCodes.NEW_USER_CONF) {
            this.currentRoomCode = "";
            if(data.get("status").equals("VALID")){
                currentRoomCode = "T";
            }else{
                currentRoomCode = "F";
            }
            return;
        }
        // server has responded to a login attempt
        if (commonconstants.reqCodes.valueOf(data.get("req")) == commonconstants.reqCodes.LOGIN_CONF){
            this.currentRoomCode = "";
            if(data.get("status").equals("VALID")){
                currentRoomCode = "T";
            }else{
                currentRoomCode = "F";
            }
            return;
        }

        if(commonconstants.reqCodes.valueOf(data.get("req")) == commonconstants.reqCodes.CHAT_HISTORY) {
            this.currentRoomCode = data.get("code");
        }

        /* Only show if in chat room */
        //System.out.println(data.get("code") + " sent to " + clientName);
        if (data.get("code").equals(currentRoomCode)) {
            if(!data.get("name").equals("Server")){
                messageArea.append(data.get("name") + ": " + toShow + "\n");
            }else{
                messageArea.append(toShow);
            }

        }
    }

    /* Add message for this user only */
    public void addMessage(String message) {
        /* Method for appending a message to the display, not for sending */

        messageArea.append(message + "\n");
    }

    public HashMap<String, String> makeData(String name, String code, commonconstants.reqCodes request,String status,String password) {
        /* Method to create a data hashmap for packaging with messages */

        HashMap<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("code", code);
        data.put("req", request.toString());
        data.put("status", status);
        data.put("password",password);

        return data;
    }

    public String packageData(String msg, HashMap<String, String> data) {
        /* Method for packaging message data with message */

        /* FORMAT => [OPENCODE]name=NAME[SEPARATOR]chat=CODE[SEPARATOR]req=CODE[CLOSECODE] [OPENCODE]MESSAGE[CLOSECODE] */

        return openCode + "name=" + data.get("name") + separator + "chat=" + data.get("code") + separator + "req=" + data.get("req") + separator + "status=" + data.get("status") + separator + "password=" + data.get("password") + closeCode + openCode + msg + closeCode;
    }

    public String unpackageData(String fullMsg, HashMap<String, String> dataOut) {
        /* Method to unpack data from received message, returns message only */

        //System.out.println(clientName + " RECEIVED: " + fullMsg);

        int dataStart = -1, dataEnd = -1;
        int msgStart = -1, msgEnd = -1;

        for (int i = 0; i < fullMsg.length() - (codesLen-1); i++) {
            /* Go through with sliding window to find data, message */
            String slidingWindow = fullMsg.substring(i, i + codesLen);

            if (dataStart == -1) {
                if (slidingWindow.equals(openCode)) {
                    /* Start not found, current char is openCode */

                    dataStart = i+codesLen;
                }
            } else if (dataEnd == -1) {
                if (slidingWindow.equals(closeCode)) {
                    /* End not found, current char is closeCode */

                    dataEnd = i+codesLen;
                }
            } else if (msgStart == -1) {
                if (slidingWindow.equals(openCode)) {
                    /* Start not found, current char is openCode */

                    msgStart = i + codesLen;
                }
            } else if (msgEnd == -1) {
                if (slidingWindow.equals(closeCode)) {
                    /* End not found, current char is closeCode */

                    msgEnd = i;
                }
            }
        }

        /* If dataOut is null, return early */
        if (dataOut == null) { return fullMsg.substring(msgStart, msgEnd); }

        /* Sort data into array */

        /* Parse only data from full message */
        String allData = fullMsg.substring(dataStart, dataEnd);

        /* Reusing data start */
        dataStart = 0;

        for (int i = 0; i < allData.length() - (codesLen-1); i++) {
            /* Go through with sliding window to parse data */
            String slidingWindow = allData.substring(i, i + codesLen);

            //System.out.println("SLIDING WINDOW (i = " + Integer.toString(i) + " of " + Integer.toString(allData.length() - (codesLen-2)) + "): " + slidingWindow);

            if (slidingWindow.equals(separator) || slidingWindow.equals(closeCode)) {
                /* Found separator, save data so far */

                String foundData = allData.substring(dataStart, i);

                /* Skip separator and begin next data */
                i += codesLen;
                dataStart = i;

                switch(foundData.split("=")[0]) {
                    case "name":
                        dataOut.put("name", foundData.substring(foundData.indexOf('=')+1));
                        break;

                    case "chat":
                        dataOut.put("code", foundData.substring(foundData.indexOf('=')+1));
                        break;

                    case "req":
                        String foundReq = foundData.substring(foundData.indexOf('=')+1);

                        try {
                            dataOut.put("req", commonconstants.reqCodes.valueOf(foundReq).toString());
                        } catch (IllegalArgumentException e) {
                            dataOut.put("req", commonconstants.reqCodes.NONE.toString());
                            catchMessage("Req not found, got: " + foundReq, false);
                        }
                        break;

                    case "status":
                        dataOut.put("status", foundData.substring(foundData.indexOf('=')+1));
                        break;

                    case "password":
                        dataOut.put("password", foundData.substring(foundData.indexOf('=')+1));
                        break;

                    default:
                        System.out.println("Strange data detected, skipping");
                }
            }
        }

        return fullMsg.substring(msgStart, msgEnd);
    }

    public void sendMessage(String message, commonconstants.reqCodes request,String status,String password) {
        /* Method for sending a message to the server, including name and displaying on gui */

        /* No blank messages without request */
        if (message.trim().isEmpty() && request == commonconstants.reqCodes.NONE) { return; }

        try {
            HashMap<String, String> data = makeData(clientName, currentRoomCode, request,status,password);

            String sendMsg = packageData(message, data);
            //System.out.println(sendMsg);
            output.writeUTF(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Sending message from client [" + e.getMessage() + "] to server [" + serverPort + "]", true);
        }
    }

    public void requestChat() {
        /* Method for requesting a new 'chatroom' from the server */

        try {
            HashMap<String, String> data = makeData(clientName, currentRoomCode, commonconstants.reqCodes.NEW_CHAT,"","");

            String sendMsg = packageData("", data);
            output.writeUTF(sendMsg);
            currentRoomCode = "WAITING";

        } catch (IOException e) {
            addMessage("Error: Failed to request new chat\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Sending chat request from client [" + e.getMessage() + "] to server [" + serverPort + "]", true);
        }
    }

    public void checkRoomExists(String roomCode) {
        currentRoomCode = roomCode;

        sendMessage("", commonconstants.reqCodes.EXISTING_CHAT,"","");
        currentRoomCode = "WAITING";
    }

    public void requestLoggedChats(String roomCode) {
        currentRoomCode = roomCode;
        sendMessage("", commonconstants.reqCodes.CHAT_HISTORY,"","");
        currentRoomCode = "WAITING";
    }

    public void checkNameNotUsed(String name,String password) {
        sendMessage("",commonconstants.reqCodes.NEW_USER,name,password);
        currentRoomCode = "WAITING";
    }

    public void checkNameAndPassword(String name, String password) {
        sendMessage("", commonconstants.reqCodes.LOGIN,name,password);
        currentRoomCode = "WAITING";
    }


    public void connect() {
        /* Method to attempt to connect to server */

        int tried = 0;

        try {

            while (tried < commonconstants.TRIES) {
                try {
                    /* Create socket to server, and output / input data streams */

                    clientSocket = new Socket("localhost", serverPort);
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    input = new DataInputStream(clientSocket.getInputStream());

                    /* Reaches here if no errors above */
                    connected = true;
                    tried = commonconstants.TRIES;

                } catch (IOException e) {
                    catchMessage("[" + tried + "] Could not connect to localhost:" + serverPort, false);
                    tried++;
                }
                Thread.sleep(10); // pause
            }

        } catch (InterruptedException e) {
            catchMessage("Thread sleep failed", true);
            throw new RuntimeException(e);
        }

        if (!connected) {
            shutdown();
        }
    }

    public void listening() {
        /* Method that runs to listen for messages */

        /* Stop if already listening */
        if (isListening) { return; }

        try {
            isListening = true;

            while (true) {
                /* Constantly read for messages and show */
                String inputLine = input.readUTF();

                addPackagedMessage(inputLine);
            }
        } catch (IOException e) {
            /* Client has left server or server has closed */
            addMessage("Leaving server, goodbye...\n");
            shutdown();

            catchMessage("Client has left server [client]", false);
        }
    }

    public void shutdown() {
        /* Method for completing all steps for disconnecting client */

        try {
            if (clientSocket != null) {
                clientSocket.close();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Failed to close client socket [" + e.getMessage() + "]", true);
        }

        isListening = false;
        connected = false;
    }

    public void setRoomCode(String roomCode) {
        this.currentRoomCode = roomCode;
    }

    public String getRoomCode() {
        return this.currentRoomCode;
    }

}