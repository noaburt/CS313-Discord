
public class TestServer {

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient();
        client.startConnection("127.0.0.1", 4444);

        String response = client.sendMessage("Hello");
        System.out.println(response);
    }

}
