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

public class NotEvenCloseToSimpleSelectionPage extends form{

    public NotEvenCloseToSimpleSelectionPage(NotSoSimpleClient client, int err) {

        /* set title bar */
        super("Home", client, 2);


        this.addGuiDesign();
    }

    /* add gui components to the NotSoSimple.form */
    public void addGuiDesign() {

        /* set background color based on theme */
        getContentPane().setBackground( commonconstants.BG_COLOR[0] );

        /* create title, labels, fields, and buttons, and add to component list */
        componentList.put("Title", commonconstants.makeTitle("DISCORD", 0));
        // welcome message
        componentList.put("welcomeMassage", commonconstants.makeSubheading("Welcome " + client.clientName + " " + (client.connected ? "Connected" : "Not Connected"), 0, formColumns[0], getRowPosition(0), SwingConstants.LEFT));
        // join global chat
        componentList.put("globalServer", commonconstants.makeButton("Connect To Global Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 260 - commonconstants.BUTTON_SIZE[1],150));
        // create chat room
        componentList.put("createServer", commonconstants.makeButton("Create Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 200 - commonconstants.BUTTON_SIZE[1],150));
        // join specific chat room
        componentList.put("selectServer", commonconstants.makeButton("Join Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 140 - commonconstants.BUTTON_SIZE[1],150));
        // disconnect
        componentList.put("disconnect", commonconstants.makeButton("Disconnect", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 80 - commonconstants.BUTTON_SIZE[1],150));
        // listeners for buttons
        componentList.get("globalServer").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                            joins global chat server

                         */
                        String code = "GLOBAL";
                        client.setRoomCode(code);
                        new simpleChatRoom(client,0 , code).setVisible(true);
                        NotEvenCloseToSimpleSelectionPage.this.dispose();
                    }
                }
        );

        componentList.get("createServer").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                            creates a new chat with unique code check for a unique code then show chat page

                         */

                    }
                }
        );
        componentList.get("selectServer").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                            ask for room code check if it is room then open the chat page if not error

                         */
                    }
                }
        );
        componentList.get("disconnect").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                                DISCONNECT THEN SHOW LOGIN PAGE

                         */
                        client.connected = false;
                        client.setRoomCode("");
                        new NotSoSimpleClientLoginPage(null,0).setVisible(true);
                        NotEvenCloseToSimpleSelectionPage.this.dispose();
                    }
                }
        );

        /* add components to NotSoSimple.form */
        addComponents();
    }


}