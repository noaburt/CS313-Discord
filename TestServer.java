import com.sun.tools.javac.Main;

public class TestServer extends Thread {

    public static void main(String[] args) {
        TestServer thread = new TestServer();
        thread.start();

        SimpleClient client = new SimpleClient();
        client.startConnection("127.0.0.1", 4444);
        String response = client.sendMessage("hello server");

        System.out.println(response);
    }

    public void run() {
        SimpleServerClient server = new SimpleServerClient();
        server.start(4444);
    }

}
