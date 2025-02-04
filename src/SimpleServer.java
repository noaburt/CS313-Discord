import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer extends SimpleClient {

    public ServerSocket serverSocket;

    public SimpleServer(int port) {
        super(port, "Server");

    }

    @Override
    public void addTextBoxes() {
        /* Method for adding only required text boxes to server window */

        messageArea = new JTextArea(10, 20);
        messageArea.setEditable(false);

        add(new JScrollPane(messageArea));
    }

    @Override
    public JPanel makePanel() {
        /* Method for adding only required buttons to window */

        JPanel panel = new JPanel();

        shutdownButton = new JButton("Shutdown Server");
        shutdownButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage("Server shutting down...");
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

            while (true) {
                Socket clientSocket = serverSocket.accept();
                output = new DataOutputStream(clientSocket.getOutputStream());
                input = new DataInputStream(clientSocket.getInputStream());

                /* Welcome client to server */
                sendMessage("A client has joined, welcome!\n");

                /* SwingWorker used for updating input / output stream */
                createMessageWorker();
            }

        } catch (IOException e) {
            e.printStackTrace();
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
    public void shutdown() {
        if (input != null) {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (output != null) {
            try {
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        addMessage("Server stopped\n");
        checkShutdown();
    }

}
