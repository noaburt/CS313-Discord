
import javax.swing.JOptionPane;

public class TestServer extends Thread {

    public static void main(String[] args) {
        SimpleGui client1 = new SimpleGui(new SimpleClient(4444, "Client 1"));
        SimpleGui server = new SimpleGui(new SimpleServer(4444));


    }
}
