
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

public class NotSoSimpleClient extends JPanel {
    /* Class for all clients to be used */

    public int serverPort;
    public String clientName;

    public Socket clientSocket;

    public DataInputStream input;
    private DataOutputStream output;

    public JTextArea messageArea;
    public JTextField messageField;
    public JButton shutdownButton;
    public JButton connectButton;

    public NotSoSimpleClient(int port, String thisName) {
        /* Setup window when client instance is created */

        serverPort = port;
        clientName = thisName;

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

    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        /* No blank messages */
        if (message.trim().isEmpty()) { return; }

        try {
            String sendMsg = clientName + ": " + message;
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

            /* First message is always client data -------------------------------------MIGHT NOT NEED KEEP FOR NOW */
            output.writeUTF("{;" + clientName + ";}");

            sendMessage("has joined the server\n");

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

    public void setClientName(String clientName) {
            this.clientName = clientName;
    }
}