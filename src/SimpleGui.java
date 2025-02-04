
import javax.swing.*;
import java.awt.*;

public class SimpleGui {

    public SimpleGui(JPanel guiPanel) {
        /* Begin gui when instance is created */

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                JFrame clientFrame = new JFrame("Simple Gui");
                clientFrame.add(guiPanel);
                clientFrame.pack();
                clientFrame.setLocationRelativeTo(null);
                clientFrame.setVisible(true);
            }
        });
    }


}
