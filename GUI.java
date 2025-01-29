import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.*;
import javax.swing.*;


public class GUI {

    public static void main(String[] args) {
        new GUI();
    }

    public GUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private ReadMessageWorker readWorker;

        private DataInputStream inputStream;
        private DataOutputStream outputStream;

        private ServerSocket serverSocket;
        private Socket socket;

        private JTextField messageField;
        private JTextArea messageArea;

        private JButton startServerButton;
        private JButton startClientButton;
        private JButton shutDownButton;

        public TestPane() {
            setLayout(new BorderLayout());

            messageField = new JTextField(10);
            messageArea = new JTextArea(10, 20);

            messageField.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        String text = messageField.getText();
                        outputStream.writeUTF(text);
                        appendMessage(text);
                        messageField.setText(null);
                    } catch (IOException ex) {
                        Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(TestPane.this, "Could not send message", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            add(new JScrollPane(messageArea));
            add(messageField, BorderLayout.NORTH);

            startServerButton = new JButton("Start Chat Room");
            startClientButton = new JButton("Connect to Chat Room");
            shutDownButton = new JButton("Shutdown");
            shutDownButton.setEnabled(false);

            JPanel actionsPanel = new JPanel();
            actionsPanel.add(startServerButton);
            actionsPanel.add(startClientButton);
            actionsPanel.add(shutDownButton);

            add(actionsPanel, BorderLayout.SOUTH);

            startServerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            createServer();
                        }
                    }).start();
                }
            });
            startClientButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            createClient();
                        }
                    }).start();
                }
            });
            shutDownButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shutdown();
                }
            });
        }

        protected void didStartServer() {
            if (!EventQueue.isDispatchThread()) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        didStartServer();
                    }
                });
                return;
            }

            startServerButton.setEnabled(false);
            startClientButton.setEnabled(false);
            shutDownButton.setEnabled(true);
        }

        protected void didStartClient() {
            if (!EventQueue.isDispatchThread()) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        didStartClient();
                    }
                });
                return;
            }
            startServerButton.setEnabled(false);
            startClientButton.setEnabled(false);
            shutDownButton.setEnabled(true);
        }

        protected void didShutdown() {
            if (!EventQueue.isDispatchThread()) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        didShutdown();
                    }
                });
                return;
            }
            startServerButton.setEnabled(true);
            startClientButton.setEnabled(true);
            shutDownButton.setEnabled(false);
        }

        protected void createClient() {
            try {
                didStartClient();
                appendMessage("Connecting to Chat Room...");
                socket = new Socket("localhost", 8000);
                inputStream = new DataInputStream(socket.getInputStream());
                outputStream = new DataOutputStream(socket.getOutputStream());
                appendMessage("Connected to room\n");
                createMessageWorker();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "No Chat Room Found", "No Room Found", JOptionPane.ERROR_MESSAGE);
                shutdown();
            }
        }

        protected void createServer() {

            try {
                didStartServer();
                appendMessage("Creating Chat Room...");
                serverSocket = new ServerSocket(4444);
                appendMessage("Waiting for other people to join...");
                while (true) {
                    Socket socket = serverSocket.accept();
                    appendMessage("User Connected To Room\n");
                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());
                    createMessageWorker();
                }

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Could not create chat room there may already be one", "Error", JOptionPane.ERROR_MESSAGE);
                shutdown();

            }
        }

        protected void createMessageWorker() {
            readWorker = new ReadMessageWorker(inputStream, new ReadMessageWorker.MessageListener() {
                @Override
                public void didRecieveMessage(String message) {
                    appendMessage(message);
                }
            });
            readWorker.addPropertyChangeListener(new PropertyChangeListener() {
                @Override
                public void propertyChange(PropertyChangeEvent evt) {
                    System.out.println(readWorker.getState());
                    if (readWorker.getState() == SwingWorker.StateValue.DONE) {
                        try {
                            readWorker.get();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ExecutionException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(TestPane.this, "Stopped reading due to error", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                        shutdown();
                    }
                }
            });
            readWorker.execute();
        }

        protected void appendMessage(String message) {
            if (!EventQueue.isDispatchThread()) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        appendMessage(message);
                    }
                });
                return;
            }
            messageArea.append(message + "\n");
        }

        protected void shutdown() {
            shutdownServer();
            shutdownSocket();
            appendMessage("\nChat Room Shutdown\n");
            didShutdown();
        }

        protected void shutdownSocket() {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                }
            }
        }

        protected void shutdownServer() {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException ex) {
                }
            }
        }

    }

    public class ReadMessageWorker extends SwingWorker<Void, String> {

        public interface MessageListener {

            public void didRecieveMessage(String message);
        }

        private DataInputStream dataInputStream;
        private AtomicBoolean continueReading;
        private MessageListener listener;

        public ReadMessageWorker(DataInputStream dataInputStream, MessageListener listener) {
            this.dataInputStream = dataInputStream;
            this.listener = listener;
            continueReading = new AtomicBoolean(true);
        }

        @Override
        protected void process(List<String> chunks) {
            for (String message : chunks) {
                listener.didRecieveMessage(message);
            }
        }

        public void stopReading() {
            continueReading.set(false);
            try {
                dataInputStream.close();
            } catch (IOException ex) {
            }
        }
        @Override
        protected Void doInBackground() throws Exception {
            while (continueReading.get()) {
                String text = dataInputStream.readUTF();
                publish(text);
            }

            System.out.println("Read is now down...");

            return null;
        }

    }
}
