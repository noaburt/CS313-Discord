
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

            String recieved;
            while ((recieved = input.readLine()) != null) {
                if ("goodbye".equals(recieved)) {
                    output.println("See you later");
                    break;
                }

                output.println("Recieved: " + recieved);
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