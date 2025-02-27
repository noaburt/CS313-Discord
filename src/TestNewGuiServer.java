import Simple.SimpleGui;
import Simple.SimpleServer;

public class TestNewGuiServer {

    public static void main(String[] args) {

        //Simple.SimpleGui client1 = new Simple.SimpleGui(new Simple.SimpleClient(4444, "Client 1"));
        //Simple.SimpleGui client2 = new Simple.SimpleGui(new Simple.SimpleClient(4444, "Client 2"));
        SimpleGui server = new SimpleGui(new SimpleServer(4444));


    }
}
