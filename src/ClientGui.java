

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class ClientGui {

    public ClientGui(int serverPort) {
        /* When new instance is created, the gui begins */

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame clientFrame = new JFrame("Client");
                clientFrame.add(new SimpleClient(serverPort));
                clientFrame.pack();
                clientFrame.setLocationRelativeTo(null);
                clientFrame.setVisible(true);
            }
        });
    }

    public class SimpleClient extends JPanel {

        private Socket clientSocket;
        private DataOutputStream output;
        private DataInputStream input;

        private ReadMessageWorker readWorker;

        private JTextField messageField;
        private JTextArea messageArea;

        private JButton shutDownButton;

        public SimpleClient(int serverPort) {
            setLayout(new BorderLayout());

            messageField = new JTextField(10);
            messageArea = new JTextArea(10, 20);
            messageArea.setEditable(false);

            add(new JScrollPane(messageArea));
            add(messageField, BorderLayout.NORTH);
            messageField.setEditable(false);

            shutDownButton = new JButton("Leave Server");

            JPanel actionsPanel = new JPanel();
            actionsPanel.add(shutDownButton);
            add(actionsPanel, BorderLayout.SOUTH);

            shutDownButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    stopConnection();
                }
            });

            startConnection("127.0.0.1", serverPort);

        }

        public void addMessage(String message) {
            /* May need to do more in the future, separate function for now */
            messageArea.append(message + "\n");
        }

        public void startConnection(String ip, int port) {
            try {
                addMessage("Connecting to server...\n");
                clientSocket = new Socket(ip, port);
                output = new DataOutputStream(clientSocket.getOutputStream());
                input = new DataInputStream(clientSocket.getInputStream());

                /* If successfully connected, allow sending messages */
                messageField.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String message = "Client: " + messageField.getText();
                            output.writeUTF(message);
                            addMessage(message);
                            messageField.setText(null);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                addMessage("Successfully connected to server\n");
                messageField.setEditable(true);
                shutDownButton.setEnabled(true);
                createMessageWorker();
            } catch (IOException e) {
                addMessage("No server found at: " + port + "\n");
                stopConnection();
            }
        }

        public void checkShutdown() {
            /* Check if server has already shutdown, make buttons active */

            if (!EventQueue.isDispatchThread()) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        checkShutdown();
                    }
                });
                return;
            }

            messageField.setEditable(false);
            shutDownButton.setEnabled(false);
        }

        public void stopConnection() {
            if (clientSocket != null) {
                try {
                    String leaveMsg = "Client has left, goodbye!\n";
                    output.writeUTF(leaveMsg);
                    addMessage(leaveMsg);

                    clientSocket.close();
                    shutDownButton.setEnabled(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            addMessage("Connection closed\n");
            checkShutdown();
        }

        public void createMessageWorker() {
            readWorker = new ReadMessageWorker(input, new ReadMessageWorker.MessageListener() {
                @Override
                public void didRecieveMessage(String message) {
                    addMessage("Server: " + message);
                }
            });

            readWorker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    System.out.println(readWorker.getState());
                    if (readWorker.getState() == SwingWorker.StateValue.DONE) {
                        try {
                            readWorker.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            ex.printStackTrace();
                        }

                        stopConnection();
                    }
                }
            });

            readWorker.execute();
        }

    }
}
