package NotSoSimple;

import javax.swing.*;
import java.util.HashMap;

public class breaker {
    static int x = 0;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* instantiate a login NotSoSimple.form and show */
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT, Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random() * 1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
            }
        });
    }
}


