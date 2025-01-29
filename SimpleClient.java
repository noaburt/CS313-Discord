
import java.net.*;
import java.io.*;

public class SimpleClient {
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            output = new PrintWriter(clientSocket.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Could not connect to " + ip + ":" + port);
        }
    }

    public String sendMessage(String msg) {
        output.println(msg);

        try {
            return input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void stopConnection() {
        try {
            input.close();
            output.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}