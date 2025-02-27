import javax.swing.*;

public class clientStarterRun {
    public static void main(String[] args) {
        NotSoSimpleClient client = new NotSoSimpleClient(4444,"Anomonous");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* instantiate a login form and show */
                new NotSoSimpleClientLoginPage(client, 0).setVisible(true);
            }
        });

    }
}
