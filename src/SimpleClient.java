
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

    private String separator;
    private String openCode;
    private String closeCode;
    private int codesLen;

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

    public void addMessage(String message) {
        /* Method for appending a message to the display, not for sending */

        messageArea.append(message + "\n");
    }

    public String packageData(String msg, String name, String chatCode, String request) {
        /* Method for packaging message data with message */

        /* FORMAT => [OPENCODE]name='NAME'[SEPARATOR]chat='CODE'[SEPARATOR]req='INT'[CLOSECODE] [OPENCODE]MESSAGE[CLOSECODE] */

        return openCode + "name='" + name + "'" + separator + "chat='" + chatCode + "'" + separator + "req='" + request + "'" + closeCode + openCode + msg + closeCode;
    }

    public void unpackageData(String fullMsg, String msgOut, String[] dataOut) {
        /* Funny method to 'return' multiple variables by setting values of params */

        /* FORMAT => [OPENCODE]name='NAME'[SEPARATOR]chat='CODE'[SEPARATOR]req='INT'[CLOSECODE] [OPENCODE]MESSAGE[CLOSECODE] */

        String curlyRegex = "\\s(?=\\{)|(?<=})\\s"; // NOT NEEDED FOR NOW

        int dataStart = -1, dataEnd = -1;
        int msgStart = -1, msgEnd = -1;

        for (int i = 0; i < fullMsg.length() - codesLen - 1; i++) {
            /* Go through with sliding window to find data, message */
            String slidingWindow = fullMsg.substring(i, i + codesLen);

            if (dataStart == -1) {
                if (slidingWindow.equals(openCode)) {
                    /* Start not found, current char is openCode */

                    dataStart = i + codesLen;
                }
            } else if (dataEnd == -1) {
                if (slidingWindow.equals(closeCode)) {
                    /* End not found, current char is closeCode */

                    dataEnd = i-1;
                }
            } else if (msgStart == -1) {
                if (slidingWindow.equals(openCode)) {
                    /* Start not found, current char is openCode */

                    msgStart = i + codesLen;
                }
            } else if (msgEnd == -1) {
                if (slidingWindow.equals(closeCode)) {
                    /* End not found, current char is closeCode */

                    msgEnd = i - 1;
                }
            }
        }

        /* Sort data into array */
        String allData = fullMsg.substring(dataStart, dataEnd);
        String name = "NONE", chat = "NONE", req = "NONE";

        /* Reusing data start */
        dataStart = 0;

        for (int i = 0; i < allData.length() - codesLen - 1; i++) {
            /* Go through with sliding window to parse data */
            String slidingWindow = fullMsg.substring(i, i + codesLen);

            if (slidingWindow.equals(separator)) {
                /* Found separator, save data so far */

                String foundData = allData.substring(dataStart, i-1);

                switch(foundData.split("=")[0]) {
                    case "name":
                        name = foundData.substring(foundData.indexOf('='));

                    case "chat":
                        chat = foundData.substring(foundData.indexOf('='));

                    case "req":
                        req = foundData.substring(foundData.indexOf('='));
                }
            }
        }

        msgOut = fullMsg.substring(msgStart, msgEnd);
        dataOut = new String[]{name, chat, req};

    }

    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        /* No blank messages */
        if (message.trim().isEmpty()) { return; }

        try {
            String sendMsg = packageData(message, clientName, currentChatCode);
            System.out.println("ENCODED: " + sendMsg);
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

                addMessage(inputLine);
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

        //checkShutdown();
        disableButtons();
    }

    public void checkShutdown() {
        /* Method to check if client has already shutdown */

        if (!EventQueue.isDispatchThread()) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    checkShutdown();
                }
            });
            return;
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