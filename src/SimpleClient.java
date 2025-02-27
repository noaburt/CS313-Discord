
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * SimpleClient
 * Implementation of JPanel class for acting as a client
 *
 * This class is instantiated and passed into SimpleGui with the JPanel content.
 * SimpleServer is an extension of this class as well, using most of the same methods.
 *
 * Actions of this Class:
 *
 * Creating gui JPanel - addTextBoxes(), makePanel()
 * Connecting to server - connect()
 * Sending messages - addMessage(), sendMessage()
 * Disconnecting server - shutdown()
 *
 */

public class SimpleClient extends JPanel {
    /* Class for all clients to be used */

    public int serverPort;

    public String clientName;
    public String currentChatCode;

    public Socket clientSocket;

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

    enum reqCodes {
        NONE,    // SENDING MESSAGE etc.
        LEAVE,   // LEAVING SERVER
        NEW_CHAT // CREATING GROUP CHAT
    };

    public SimpleClient(int port, String thisName) {
        /* Setup window when client instance is created */

        serverPort = port;
        clientName = thisName;
        currentChatCode = "mainchat";

        /* This separates the data no matter what */
        separator = ",-=;#";

        /* This stops the user being able to type a message to close the message early (I HOPE) I HATE MYSELF THIS IS A PAIN */
        openCode = "['*{!";
        closeCode = "!}*']";

        codesLen = openCode.length(); // All same length

        setLayout(new BorderLayout());
        addTextBoxes();

        JPanel actionsPanel = makePanel();
        add(actionsPanel, BorderLayout.SOUTH);

        disableButtons();
    }

    public void addTextBoxes() {
        /* Method for adding only required text boxes to window */

        messageArea = new JTextArea(10, 20);
        messageArea.setEditable(false);

        messageField = new JTextField(10);
        messageField.setEditable(false);

        /* Keep scroll always showing the newest messages */
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        add(scrollPane);
        add(messageField, BorderLayout.NORTH);
    }

    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Leave Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage("has left the server\n");
                shutdown();
            }
        });

        connectButton = new JButton("Connect to server");
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

    public void catchMessage(String message, boolean error) {
        /* Nice way of clarifying errors from try-catch blocks */

        System.out.println((error ? "Error: " : "Caught: ") + message);
    }

    /* Add message FROM someone */
    public void addPackagedMessage(String inputLine) {
        /* Method for appending a message to the display, not for sending */
        Map<String, String> data = new HashMap<>();
        String toShow = unpackageData(inputLine, data);

        messageArea.append(data.get("name") + ": " + toShow + "\n");
    }

    /* Add message for this user only */
    public void addMessage(String message) {
        /* Method for appending a message to the display, not for sending */

        messageArea.append(message + "\n");
    }

    public String packageData(String msg, Map<String, String> data) {
        /* Method for packaging message data with message */

        /* FORMAT => [OPENCODE]name=NAME[SEPARATOR]chat=CODE[SEPARATOR]req=CODE[CLOSECODE] [OPENCODE]MESSAGE[CLOSECODE] */

        return openCode + "name=" + data.get("name") + separator + "chat=" + data.get("code") + separator + "req=" + data.get("req") + closeCode + openCode + msg + closeCode;
    }

    public String unpackageData(String fullMsg, Map<String, String> dataOut) {
        /* Method to unpack data from received message, returns message only */

        /* FORMAT => [OPENCODE]name=NAME[SEPARATOR]chat=CODE[SEPARATOR]req=CODE[CLOSECODE] [OPENCODE]MESSAGE[CLOSECODE] */

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
        String name = "NONE", chat = "NONE";
        reqCodes req = reqCodes.NONE;

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
                        name = foundData.substring(foundData.indexOf('=')+1);
                        break;

                    case "chat":
                        chat = foundData.substring(foundData.indexOf('=')+1);
                        break;

                    case "req":
                        String foundReq = foundData.substring(foundData.indexOf('=')+1);

                        try {
                            req = reqCodes.valueOf(foundReq);
                        } catch (IllegalArgumentException e) {
                            req = reqCodes.NONE;
                            catchMessage("Req not found, got: " + foundReq, false);
                        }
                        break;

                    default:
                        System.out.println("Strange data detected, skipping");
                }
            }
        }

        dataOut.put("name", name);
        dataOut.put("chat", chat);
        dataOut.put("req", req.name());

        return fullMsg.substring(msgStart, msgEnd);
    }

    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        /* No blank messages */
        if (message.trim().isEmpty()) { return; }

        try {
            Map<String, String> data = new HashMap<String, String>();
            data.put("name", clientName);
            data.put("code", currentChatCode);
            data.put("req", reqCodes.NONE.name());

            String sendMsg = packageData(message, data);
            output.writeUTF(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Sending message from client [" + e.getMessage() + "] to server [" + serverPort + "]", true);
        }
    }

    public void connect() {
        /* Method to attempt to connect to server */

        addMessage("Connecting to server...");

        try {
            /* Create socket to server, and output / input data streams */
            clientSocket = new Socket("localhost", serverPort);
            output = new DataOutputStream(clientSocket.getOutputStream());
            input = new DataInputStream(clientSocket.getInputStream());

            sendMessage("has joined the server");

        } catch (IOException e) {
            addMessage("No server found @ localhost:" + serverPort + "\n");
            shutdown();

            catchMessage("Didn't find server", false);
            return;
        }

        try {
            /* If connects successfully, allow sending messages, activate buttons */
            messageField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage(messageField.getText());
                    messageField.setText(null);
                }
            });

            enableButtons();
            addMessage("Successfully connected to server\n");

            /* While loops continue until exception is thrown */
            while (true) {
                /* Constantly read for messages and show */
                String inputLine = input.readUTF();

                addPackagedMessage(inputLine);
            }
        } catch (IOException e) {
            /* Client has left server or server has closed */
            addMessage("Leaving server, goodbye...\n");
            shutdown();

            catchMessage("Client left server", false);
        }
    }

    public void shutdown() {
        /* Method for completing all steps for disconnecting client */

        try {
            clientSocket.close();
        } catch (IOException e) {
            addMessage("Error: Failed to leave server\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Failed to close client socket [" + e.getMessage() + "]", true);
        }

        disableButtons();
    }

    public void disableButtons() {
        /* Method to enable / disable buttons when connection ended */

        messageField.setEditable(false);
        connectButton.setEnabled(true);
        shutdownButton.setEnabled(false);
    }

    public void enableButtons() {
        /* Method to enable / disable buttons when connection started */

        messageField.setEditable(true);
        connectButton.setEnabled(false);
        shutdownButton.setEnabled(true);
    }
}