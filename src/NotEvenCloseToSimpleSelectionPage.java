import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * SimpleGui
 * General gui class for all servers and clients
 *
 * When instantiated, the JPanel class parameter is added to the JFrame, and the gui is started.
 * The run() method is run in a thread by EventQueue.invokeLater()
 */

public class NotEvenCloseToSimpleSelectionPage extends form{

    public NotEvenCloseToSimpleSelectionPage(NotSoSimpleClient client, int err) {

        /* set title bar */
        super("Login", client, 2);


        this.addGuiDesign();
    }

    /* add gui components to the form */
    public void addGuiDesign() {

        /* set background color based on theme */
        getContentPane().setBackground( commonconstants.BG_COLOR[0] );

        /* create title, labels, fields, and buttons, and add to component list */
        componentList.put("Title", commonconstants.makeTitle("DISCORD", 0));

        componentList.put("welcomeMassage", commonconstants.makeSubheading("Welcome " + client.clientName, 0, formColumns[0], getRowPosition(0), SwingConstants.LEFT));


        componentList.put("loginButton", commonconstants.makeButton("Connect To Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 80 - commonconstants.BUTTON_SIZE[1]));





        componentList.get("loginButton").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {

                    }
                }
        );

        /* add components to form */
        addComponents();
    }

    /* validate login details, login or display error
     *
     * @return int: error code (from commonconstants)
     */



}