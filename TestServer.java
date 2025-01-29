
public class TestServer {

    public static void main(String[] args) {
        SimpleServerClient server = new SimpleServerClient();
        server.start(6666);

        SimpleClient client = new SimpleClient();
        client.startConnection("127.0.0.1", 6666);
        String response = client.sendMessage("hello server");

        System.out.println(response);
    }

}
