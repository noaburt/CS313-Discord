package NotSoSimple;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Simple.SimpleGui
 * General gui class for all servers and clients
 *
 * When instantiated, the JPanel class parameter is added to the JFrame, and the gui is started.
 * The run() method is run in a thread by EventQueue.invokeLater()
 */

public class NotSoSimpleClientLoginPage extends form{

    public NotSoSimpleClientLoginPage(NotSoSimpleClient client, int err) {

        /* set title bar */
        super("Connect", client, 2);


        this.addGuiDesign();
    }

    /* add gui components to the NotSoSimple.form */
    public void addGuiDesign() {

        /* set background color based on theme */
        getContentPane().setBackground( commonconstants.BG_COLOR[0] );

        /* create title, labels, fields, and buttons, and add to component list */
        componentList.put("Title", commonconstants.makeTitle("DISCORD", 0));

        componentList.put("uNameHead", commonconstants.makeSubheading("Display Name", 0, formColumns[0], getRowPosition(0), SwingConstants.LEFT));

        textComponentList.put("uNameField", commonconstants.makeTextField(0, formColumns[0], getRowPosition(0) + commonconstants.FIELD_DIST));

        componentList.put("loginButton", commonconstants.makeButton("Connect To Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 80 - commonconstants.BUTTON_SIZE[1],150));





        componentList.get("loginButton").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                                DO CONNECTION STUFF HERE THEN IF CONNECT SHOW 'HOME' PAGE

                         */
                        NotSoSimpleClient CLIENT = new NotSoSimpleClient(commonconstants.PORT,textComponentList.get("uNameField").getText());
                        CLIENT.connect();
                        client = CLIENT;
                        new NotEvenCloseToSimpleSelectionPage(client, 0).setVisible(true);
                        NotSoSimpleClientLoginPage.this.dispose();
                    }
                }
        );

        /* add components to NotSoSimple.form */
        addComponents();
    }



}
