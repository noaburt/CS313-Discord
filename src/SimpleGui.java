
import javax.swing.*;
import java.awt.*;

/*
 * SimpleGui
 * General gui class for all servers and clients
 *
 * When instantiated, the JPanel class parameter is added to the JFrame, and the gui is started.
 * The run() method is run in a thread by EventQueue.invokeLater()
 */

public class SimpleGui {

    public SimpleGui(JPanel guiPanel) {
        /* Begin gui when instance is created */

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame clientFrame = new JFrame("Discord");
                clientFrame.add(guiPanel);
                clientFrame.pack();
                clientFrame.setLocationRelativeTo(null);
                clientFrame.setVisible(true);
            }
        });
    }


}
