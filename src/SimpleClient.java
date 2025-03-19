import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.*;
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

    public Socket clientSocket;

    public DataInputStream input;
    private DataOutputStream output;

    public JPanel messagePanel; // Panel to hold messages
    public JTextField messageField;
    public JButton shutdownButton;
    public JButton connectButton;
    public JButton uploadButton;

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
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));

        JScrollPane scrollPane = new JScrollPane(messagePanel);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        messageField = new JTextField(10);
        messageField.setEditable(false);

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

        uploadButton = new JButton("Upload");
        uploadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                /* Method for choosing and uploading a file to the server */
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(SimpleClient.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    /* Method to send file to the server */
                    try {
                        FileInputStream fileInputStream = new FileInputStream(selectedFile);
                        byte[] buffer = new byte[4096];
                        int bytesRead;

                        // Inform server about the file
                        output.writeUTF("file:" + selectedFile.getName() + ":" + selectedFile.length());

                        // Send the file content
                        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                            output.write(buffer, 0, bytesRead);
                        }

                        fileInputStream.close();
                        addMessage("Uploaded file: " + selectedFile.getName());
                    } catch (IOException ex) {
                        addMessage("Error: Failed to upload file '" + selectedFile.getName() + "'\n(" + ex.getMessage() + ")");
                    }
                }
            }
        });

        panel.add(shutdownButton);
        panel.add(connectButton);
        panel.add(uploadButton);
        return panel;
    }

    public void catchMessage(String message, boolean error) {
        /* Nice way of clarifying errors from try-catch blocks */
        System.out.println((error ? "Error: " : "Caught: ") + message);
    }

    public void addMessage(String message) {
        /* Method for appending a message to the display, not for sending */
        JLabel messageLabel = new JLabel(message);
        messagePanel.add(messageLabel);
        messagePanel.revalidate();
        messagePanel.repaint();
    }

    public void displayImage(String imagePath) {
        /* Method to display an image in the message area */
        ImageIcon imageIcon = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(imageIcon);
        messagePanel.add(imageLabel);
        messagePanel.revalidate();
        messagePanel.repaint();
    }

    public void sendMessage(String message) {
        /* Method for sending a message to the server, including name and displaying on gui */
        /* No blank messages */
        if (message.trim().isEmpty()) {
            return;
        }

        try {
            String sendMsg = clientName + ": " + message;
            output.writeUTF(sendMsg);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
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

            /* First message is always client data */
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

                // Check if the line contains "A file has been uploaded"
                if (inputLine.startsWith("A file has been uploaded: ")) {
                    String fileName = inputLine.substring("A file has been uploaded: ".length());
                    displayImage("uploads/" + fileName);
                } else {
                    addMessage(inputLine);
                }
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
            catchMessage("Failed to close client socket [" + e.getMessage() + "]", true);
        }

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
        uploadButton.setEnabled(false);
    }

    public void enableButtons() {
        /* Method to enable / disable buttons when connection started */
        messageField.setEditable(true);
        connectButton.setEnabled(false);
        shutdownButton.setEnabled(true);
        uploadButton.setEnabled(true);
    }
}
