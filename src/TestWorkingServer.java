import Simple.SimpleClient;
import Simple.SimpleGui;
import Simple.SimpleServer;

public class TestWorkingServer {

    public static void main(String[] args) {
        new SimpleGui(new SimpleClient(4444, "Client 1"));
        new SimpleGui(new SimpleClient(4444, "Client 2"));
        new SimpleGui(new SimpleClient(4444, "Client 3"));

        new SimpleGui(new SimpleServer(4444));
    }
}
