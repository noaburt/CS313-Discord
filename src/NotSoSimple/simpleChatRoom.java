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

public class simpleChatRoom extends form{

    private String code;
    public simpleChatRoom(NotSoSimpleClient client, int err, String code) {

        /* set title bar */
        super("Chat Room", client, 2);
        this.code = code;
        this.addGuiDesign();
    }

    /* add gui components to the NotSoSimple.form */
    public void addGuiDesign() {
        /* set background color based on theme */
        getContentPane().setBackground( commonconstants.BG_COLOR[0] );

        /* create title, labels, fields, and buttons, and add to component list */
        componentList.put("Title", commonconstants.makeTitle("DISCORD", 0));
        componentList.put("Subtitle", commonconstants.makeSubheading(code, 0,formColumns[0],getRowPosition(0)+ (commonconstants.FIELD_DIST/2) - 65 , SwingConstants.LEFT));

        JTextArea messages = new JTextArea();
        messages.setEditable(false);
        JTextArea message = new JTextArea();

        componentList.put("Messages", commonconstants.makeScroller(0, formColumns[0], getRowPosition(0) + (commonconstants.FIELD_DIST/2), this.getWidth() - (formColumns[0]*2), 200, messages));
        componentList.put("Message", commonconstants.makeScroller(0, formColumns[0], getRowPosition(0) + (commonconstants.FIELD_DIST/2) + 200, this.getWidth() - (formColumns[0]*2), 20, message));

        // disconnect
        componentList.put("leaveChat", commonconstants.makeButton("Leave Chat", 0, formColumns[0], commonconstants.WIN_SIZE[1] - commonconstants.BUTTON_SIZE[1] - 70,0));

        // listeners

        componentList.get("leaveChat").addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /*

                    close this open home page

                 */

                new NotEvenCloseToSimpleSelectionPage(client,0).setVisible(true);  // THIS MIGHT GIVE PROBLEMS AS VALIDATIOPN ON CONNECTION NOT REDONE PROPERLY
                simpleChatRoom.this.dispose();
            }
        });

        /* add components to NotSoSimple.form */
        addComponents();
    }


}