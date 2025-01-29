
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

        String response = client.sendMessage("hello server");
        System.out.println(response);

        response = client.sendMessage("hello client");
        System.out.println(response);

    }

}
