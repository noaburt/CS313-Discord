package PurelyBreaker4;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class clientStarterRun {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* instantiate a login NotSoSimple.form and show */
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleServer S = new NotSoSimpleServer(commonconstants.PORT);
                        S.connect();
                    }
                }).start();
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                new NotSoSimpleClientLoginPage(null, 0).setVisible(true);
                new NotSoSimpleClientLoginPage(null, 0).setVisible(true);
                //new NotSoSimpleClientLoginPage(null, 0).setVisible(true);
            }
        });

    }
}
