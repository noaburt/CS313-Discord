import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;

    public ArrayList<ClientHandler> clients;

    public SimpleServer(int port) {
        super(port, "Server");

        clients = new ArrayList<>();
    }

    @Override
    public void addTextBoxes() {
        /* Method for adding only required text boxes to server window */

        messageArea = new JTextArea(10, 20);
        messageArea.setEditable(false);

        /* Keep scroll always showing the newest messages */
        JScrollPane scrollPane = new JScrollPane(messageArea);
        scrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });

        add(scrollPane);
    }

    public void catchMessage(String message, boolean error) {
        /* Nice way of clarifying errors from try-catch blocks */

        System.out.println((error ? "Error: " : "Caught: ") + message);
    }

    @Override
    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Shutdown Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage("shutting down...");
                shutdown();
            }
        });

        connectButton = new JButton("Start server");
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

    @Override
    public void connect() {
        /* Method to attempt to start server */

        try {
            checkStartServer();
            addMessage("Creating server at port " + serverPort);

            serverSocket = new ServerSocket(serverPort);

            addMessage("Server active...\n");

        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Connecting to server [" + e.getMessage() + "]", true);
        }

        try {
            while (true) {
                clients.add(new ClientHandler(serverSocket.accept()));
                clients.getLast().start();
            }
        } catch (IOException e) {
            //e.printStackTrace();
            catchMessage("Client socket accept", true);
        }

    }

    private class ClientHandler extends Thread {
        private Socket clientSocket;
        private DataInputStream thisInput;
        private DataOutputStream thisOutput;
        private String clientName;

        public boolean closed;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
            this.closed = false;
        }

        public void run() {
            /* First message is always name etc */
            try {
                thisInput = new DataInputStream(this.clientSocket.getInputStream());

                /* Client data in form {;name;} */
                String readClientData = thisInput.readUTF();
                this.clientName = readClientData.split(";")[1];

                thisOutput = new DataOutputStream(clientSocket.getOutputStream());
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Starting data stream", true);

                shutdownClient();
            }

            String inputLine;

            try {
                while (true) {
                    /* Read input and resend */
                    inputLine = thisInput.readUTF();

                    /* Resend message to all clients */
                    resendMessage(inputLine);

                    if (inputLine.split(":")[1].equals(" has left the server\n")) {
                        //System.out.println(clientName + " has left, client handler shutdown");
                        this.shutdownClient();
                    }
                }
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Connection closed", false);

                shutdownClient();
            }
        }

        public void shutdownClient() {
            if (thisInput != null) {
                try {
                    thisInput.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    catchMessage("Closing client input stream", true);
                }
            }

            if (thisOutput != null) {
                try {
                    thisOutput.close();
                } catch (IOException e) {
                    //e.printStackTrace();
                    catchMessage("Closing client output stream", true);
                }
            }

            this.closed = true;
        }
    }

    public void checkStartServer() {
        /* Check if a server is already started, make button inactive */

        if (!EventQueue.isDispatchThread()) {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    checkStartServer();
                }
            });
            return;
        }

        enableButtons();
    }

    @Override
    public void disableButtons() {
        /* Method to enable / disable buttons when connection ended */

        connectButton.setEnabled(true);
        shutdownButton.setEnabled(false);
    }

    @Override
    public void enableButtons() {
        /* Method to enable / disable buttons when connection started */

        connectButton.setEnabled(false);
        shutdownButton.setEnabled(true);
    }

    @Override
    public void sendMessage(String message) {
        /* Method for sending a message from the server, with server name */

        try {
            String sendMsg = clientName + ": " + message;

            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(message);
                }
            }

            messageArea.append(sendMsg + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to send message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Sending message from server [" + e.getMessage() + "]", true);
        }
    }

    public void resendMessage(String message) {
        /* Method for sending a message to all clients */

        try {
            for (ClientHandler client : clients) {
                if (!client.closed) {
                    client.thisOutput.writeUTF(message);
                }
            }

            messageArea.append(message + "\n");
        } catch (IOException e) {
            addMessage("Error: Failed to resend message '" + message + "'\n(" + e.getMessage() + ")");

            //e.printStackTrace();
            catchMessage("Resending message to clients [" + e.getMessage() + "]", true);
        }
    }

    @Override
    public void shutdown() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Closing server input stream", true);
            }
        }

        for (ClientHandler client : clients) {
            client.shutdownClient();
        }

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                //e.printStackTrace();
                catchMessage("Closing server socket", true);
            }
        }

        addMessage("Server stopped\n");
        checkShutdown();
    }
}
