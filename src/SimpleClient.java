import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class SimpleClient extends JPanel {
    /* Class for all clients to be used */

    private int serverPort;

    private Socket clientSocket;

    private DataInputStream input;
    private DataOutputStream output;

    private ReadMessageWorker messageWorker;
    private String clientName;

    private JTextArea messageArea;
    private JTextField messageField;
    private JButton shutdownButton;
    private JButton connectButton;

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

        add(new JScrollPane(messageArea));
        add(messageField, BorderLayout.NORTH);
    }

    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Leave Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { shutdown(); }
        });

        connectButton = new JButton("Connect to server");
        connectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { connect(); }
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

        try {
            String sendMsg = clientName + ": " + message;
            output.writeUTF(sendMsg);
            addMessage(sendMsg);
            messageField.setText(null);
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");
            e.printStackTrace();
        }
    }

    public void connect() {
        /* Method to attempt to connect to server */

        try {
            addMessage("Connecting to server...\n");

            clientSocket = new Socket("localhost", serverPort);
            output = new DataOutputStream(clientSocket.getOutputStream());
            input = new DataInputStream(clientSocket.getInputStream());

            /* If connects successfully, allow sending messages */
            messageField.setEditable(true);
            messageField.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage(messageField.getText());
                }
            });

            enableButtons();
            createMessageWorker();

            addMessage("Successfully connected to server\n");
        } catch (IOException e) {
            addMessage("No server found: localhost@" + serverPort + "\n");
            shutdown();
        }
    }

    public void shutdown() {
        /* Method for completing all steps for shutting down client */

        if (clientSocket != null) {
            try {
                sendMessage("has left the server, goodbye\n");

                clientSocket.close();
                shutdownButton.setEnabled(false);
            } catch (IOException e) {
                addMessage("Error: Failed to leave server\n(" + e.getMessage() + ")");
                e.printStackTrace();
            }
        }

        addMessage("Connection closed\n");
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

    public void createMessageWorker() {
        /* Method for creating a message worker for reading messages from server */

        messageWorker = new ReadMessageWorker(input, new ReadMessageWorker.MessageListener() {
            @Override
            public void didRecieveMessage(String message) {
                addMessage(message);
            }
        });

        messageWorker.addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println(messageWorker.getState());
                if (messageWorker.getState() == SwingWorker.StateValue.DONE) {
                    try {
                        messageWorker.get();
                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }

                    shutdown();
                }
            }
        });

        messageWorker.execute();
    }
}