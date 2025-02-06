import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class SimpleClient extends JPanel {
    /* Class for all clients to be used */

    public int serverPort;
    public String clientName;

    public Socket clientSocket;

    public DataInputStream input;
    public DataOutputStream output;

    public JTextArea messageArea;
    public JTextField messageField;
    public JButton shutdownButton;
    public JButton connectButton;

    public SimpleClient(int port, String thisName) {
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
                sendMessage("has left the server, goodbye\n");
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

    public void addMessage(String message) {
        /* Method for appending a message to the display, not for sending */

        messageArea.append(message + "\n");
    }

    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */

        /* No blank messages */
        if (message.trim().equals("")) { return; }

        try {
            String sendMsg = clientName + ": " + message;
            output.writeUTF(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    public void connect() {
        /* Method to attempt to connect to server */

        addMessage("Connecting to server...");

        try {
            clientSocket = new Socket("localhost", serverPort);
            output = new DataOutputStream(clientSocket.getOutputStream());
            input = new DataInputStream(clientSocket.getInputStream());

            sendMessage("has joined the server\n");
        } catch (IOException e) {
            addMessage("No server found: localhost@" + serverPort + "\n");
            shutdown();
        }

        try {
            /* If connects successfully, allow sending messages */
            messageField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage(messageField.getText());
                    messageField.setText(null);
                }
            });

            enableButtons();
            addMessage("Successfully connected to server\n");

            while (true) {
                /* Constantly read for messages and show */
                String inputLine = input.readUTF();

                addMessage(inputLine);
            }
        } catch (IOException e) {
            /* Client has left server or server has closed */
            addMessage("Leaving server, goodbye...\n");
            shutdown();
        }
    }

    public void shutdown() {
        /* Method for completing all steps for shutting down client */

        try {
            clientSocket.close();
        } catch (IOException e) {
            addMessage("Error: Failed to leave server\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }

        checkShutdown();
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