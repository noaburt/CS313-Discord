
import javax.swing.JOptionPane;

public class TestServer extends Thread {

    public static void main(String[] args) {
        TestServer thread = new TestServer();
        thread.start();

        SimpleServerClient server = new SimpleServerClient();
        server.start(4444);

    }

    public void run() {
        SimpleClient client = new SimpleClient();
        client.startConnection("127.0.0.1", 4444);

        String response = client.sendMessage(JOptionPane.showInputDialog("Enter a greeting:"));
        System.out.println(response);

        String response2 = client.sendMessage("hello client");
        System.out.println(response2);

        String response3 = client.sendMessage("goodbye");
        System.out.println(response3);

        client.stopConnection();

    }

}
