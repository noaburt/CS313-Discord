
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutionException;

public class ServerGui {

    public ServerGui() {
        /* When new instance is created, the gui begins */

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame serverFrame = new JFrame("Server");
                serverFrame.add(new SimpleServer());
                serverFrame.pack();
                serverFrame.setLocationRelativeTo(null);
                serverFrame.setVisible(true);
            }
        });
    }

    public class SimpleServer extends JPanel {

        private int serverPort;
        private ReadMessageWorker readWorker;

        private ServerSocket serverSocket;

        private DataOutputStream output;
        private DataInputStream input;

        private JTextArea messageArea;

        private JButton startServerButton;
        private JButton startClientButton;
        private JButton shutDownButton;

        public SimpleServer() {
            serverPort = 4444;
            setLayout(new BorderLayout());

            messageArea = new JTextArea(10, 20);
            messageArea.setEditable(false);

            add(new JScrollPane(messageArea));

            startServerButton = new JButton("Start Server");
            startClientButton = new JButton("Open New Client");
            shutDownButton = new JButton("ShutDown Server");
            shutDownButton.setEnabled(false);

            JPanel actionsPanel = new JPanel();
            actionsPanel.add(startServerButton);
            actionsPanel.add(startClientButton);
            actionsPanel.add(shutDownButton);

            add(actionsPanel, BorderLayout.SOUTH);

            startServerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Thread(new Runnable() {
                        public void run() {
                            startServer(serverPort);
                        }
                    }).start();
                }
            });

            startClientButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    new Thread(new Runnable() {
                        public void run() {
                            startClient(serverPort);
                        }
                    }).start();
                }
            });

            shutDownButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    stopServer();
                }
            });

        }

        public void addMessage(String message) {
            /* May need to do more in the future, separate function for now */
            messageArea.append(message + "\n");
        }

        public void startServer(int port) {
            try {
                addMessage("Creating server at port " + port + "\n");

                serverSocket = new ServerSocket(port);

                addMessage("Server active...\n");
                shutDownButton.setEnabled(true);

                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    output = new DataOutputStream(clientSocket.getOutputStream());
                    input = new DataInputStream(clientSocket.getInputStream());
                    addMessage("User Connected To Room\n");

                    /* SwingWorker used for updating input / output stream */
                    createMessageWorker();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void startClient(int serverPort) {
            addMessage("Creating client\n");
            new ClientGui(serverPort);
        }

        public void createMessageWorker() {
            readWorker = new ReadMessageWorker(input, new ReadMessageWorker.MessageListener() {
                @Override
                public void didRecieveMessage(String message) {
                    addMessage(message);
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

                        stopServer();
                    }
                }
            });
            readWorker.execute();
        }

        public void stopServer() {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (output != null) {
                try {
                    output.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            addMessage("Server stopped\n");
        }

    }
}
