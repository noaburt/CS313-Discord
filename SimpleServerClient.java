
import java.net.*;
import java.io.*;

public class SimpleServerClient {
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            String greeting = input.readLine();
            if ("hello server".equals(greeting)) {
                output.println("hello client");
            } else {
                output.println("unrecognised greeting");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try {
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}