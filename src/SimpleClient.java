
import java.net.*;
import java.io.*;

public class SimpleClient {
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;

    public void makeConnection(String ip, int port) {
        clientSocket = new Socket(ip, port);
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    public String sendMessage(String message) {
        output.println(message);
        String resp = input.readLine();
        return resp;
    }

    public void closeConnection() {
        input.close();
        output.close();
        clientSocket.close();
    }
}