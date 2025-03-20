package NotSoSimple;

import javax.swing.*;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class commonconstants {

    public static final int PORT = 4444;

    /* Client request codes */
    enum reqCodes {
        NONE,          // SENDING MESSAGE etc.
        LEAVE,         // LEAVING SERVER
        NEW_CHAT,      // CREATING GROUP CHAT
        NEW_CHAT_CONF,  // CONFIRMING NEW GC CODE
        EXISTING_CHAT, // CONFIRMING CHAT EXISTS
        CHAT_HISTORY // GETTING LOGGED MESSAGES
    };


    /* gui theme */
    public static final int THEME_DARK = 1;
    public static final int THEME_LIGHT = 0;

    /* border constants */
    public static final int BORDER_THICC = 3;

    /* gui sizes */
    public static final int FIELD_DIST = 70;
    public static final int[] WIN_SIZE = {600, 450};
    public static final int[] LABEL_SIZE = {300, 100};
    public static final int[] TFIELD_SIZE = {WIN_SIZE[0]/2, 35};
    /* Note: always subtract x co-ord from width to align with center */

    public static final int[] BUTTON_SIZE = {150, 45};

    /* color hex values for gui                 { LIGHT    ,      DARK }*/
    public static final Color[] BG_COLOR = {Color.decode("#ffffff"), Color.decode("#1B263B")};
    public static final Color[] TFIELD_COLOR = {Color.decode("#00B4D8"), Color.decode("#415A77")};
    public static final Color[] TEXT_COLOR = {Color.decode("#000000"), Color.decode("#ffffff")};

    public static final Color[] TFIELD_BORDER = {Color.decode("#0A546B"), Color.decode("#282F3E")};


    /* text field insets */
    public static final Insets TFIELD_INSETS = new Insets(0, 10, 0, 10);

    /* fonts for gui */
    public static final Font HEADER_FONT = new Font("Dialog", Font.BOLD, 50);
    public static final Font SUBHEAD_FONT = new Font("Dialog", Font.BOLD, 18);
    public static final Font BUTTON_FONT = new Font("Dialog", Font.BOLD, 16);
    public static final Font TEXT_FONT = new Font("Dialog", Font.PLAIN, 13);
    public static final Font ERR_FONT = new Font("Dialog", Font.BOLD, 13);


    /* general codes */
    public static final int SUCCESS = 0;
    public static final int FAILED = -1;

    /* login types, order by privileges */
    public static final int ADMIN = 101;
    public static final int SCH_MANAGER = 102;
    public static final int TEACHER = 103;
    public static final int STUDENT = 104;

    /* gui error label types */
    public static final String[] ERR_MSGS = {
            "<HTML>Password must include:<br>   - at least 8 characters<br>   - at least 1 upper-case character<br>   - at least 1 special character<br>   - no spaces</HTML>",
            "<HTML>Login Incorrect:<br>No such user / incorrect password</HTML>",
            "Email of incorrect format",
            "Passwords do not match",
            "You have left required field(s) empty",
            "The specified rule does not exist"
    };

    public static final int PASSWORD_ERR = 1;
    public static final int LOGIN_ERR = 2;
    public static final int EMAIL_ERR = 3;
    public static final int PASSWORD_MATCH_ERR = 4;
    public static final int EMPTY_ERR = 5;
    public static final int RULE_ERR = 6;

    /* password validation */
    public static boolean containsUppers(String toCheck) {

        for (char c : toCheck.toCharArray()) {
            if (Character.isUpperCase(c)) {
                return true;
            }
        }

        return false;
    }

    public static boolean containsSpecials(String toCheck) {
        char[] specials = {'!', '@', '%', '+', '#', '$', '&'};

        for (char c : specials) {
            if (toCheck.contains(Character.toString(c))) {
                return true;
            }
        }

        return false;
    }


    /* function for creating a default title label
     *
     * @param String: text for title label to display
     * @param int: forms current guiTheme state ( 0 - light, 1 - dark )
     * @return JLabel: created and formatted title label
     */
    public static JLabel makeTitle(String title, int guiTheme) {
        JLabel newTitle = new JLabel(title);

        newTitle.setBounds(0, 10, WIN_SIZE[0], 70);
        newTitle.setForeground( TEXT_COLOR[guiTheme] );
        newTitle.setFont( HEADER_FONT );
        newTitle.setHorizontalAlignment(SwingConstants.CENTER);

        return newTitle;
    }


    /* function for creating a default subheading label
     *
     * @param string: text for label to display
     * @param int: forms current guiTheme state
     * @param int: x location to show label
     * @param int: y location to show label
     * @param int: how to align the label text ( provided by SwingConstants )
     * @return JLabel: created and formatted field label
     */
    public static JLabel makeSubheading(String text, int guiTheme, int x, int y, int align) {
        JLabel newSubheadLabel = new JLabel(text);

        newSubheadLabel.setBounds(x, y, LABEL_SIZE[0], LABEL_SIZE[1]);
        newSubheadLabel.setForeground( TEXT_COLOR[guiTheme] );
        newSubheadLabel.setFont( SUBHEAD_FONT );
        newSubheadLabel.setHorizontalAlignment(align);

        return newSubheadLabel;
    }

    /* function for creating a default text entry field
     *
     * @param int: forms current guiTheme state
     * @param int: x location to show text field
     * @param int: y location to show text field
     * @return JTextField: created and formatted text field
     */
    public static JTextField makeTextField(int guiTheme, int x, int y) {
        JTextField newTextField = new JTextField();

        newTextField.setBounds(x, y, TFIELD_SIZE[0] - 20, TFIELD_SIZE[1]);
        newTextField.setBackground( TFIELD_COLOR[guiTheme] );
        newTextField.setForeground( TEXT_COLOR[guiTheme] );
        newTextField.setMargin( TFIELD_INSETS);
        newTextField.setFont( TEXT_FONT );

        //rounded border that didnt work
        //newTextField.setBorder(BorderFactory.createLineBorder( FIELD_BORDER[guiTheme], BORDER_THICC, true ));

        return newTextField;
    }

    /* function for creating a default scroller object
     *
     * @param int: current guiTheme
     * @param int: x position to display
     * @param int: y position to display
     * @param int: width of scroller box
     * @param int: height of scroller box
     * @param JComponent: components to be contained in scroller
     * @return JScrollPane: created and formatted scroller object
     */
    public static JScrollPane makeScroller(int guiTheme, int x, int y, int width, int height, JComponent contents) {
        JScrollPane listScroller = new JScrollPane( contents );
        listScroller.setBounds(x, y, width, height);

        /*listScroller.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {
            public void adjustmentValueChanged(AdjustmentEvent e) {
                e.getAdjustable().setValue(e.getAdjustable().getMaximum());
            }
        });*/

        return listScroller;
    }

    /* function for creating a default selection button
     * Note: add item listener externally
     *
     * @param String: text to be shown on button
     * @param int: forms current guiTheme state
     * @param int: x location to show button
     * @param int: y location to show button
     * @return JButton: created and formatted button
     */
    public static JButton makeButton(String text, int guiTheme, int x, int y,int sizeAjust) {
        JButton newButton = new JButton(text);

        newButton.setBounds(x, y, BUTTON_SIZE[0] + sizeAjust, BUTTON_SIZE[1]);
        newButton.setBackground( TFIELD_COLOR[guiTheme] );
        newButton.setForeground( TEXT_COLOR[guiTheme] );
        newButton.setFont( BUTTON_FONT );
        newButton.setCursor( Cursor.getPredefinedCursor(Cursor.HAND_CURSOR) );

        newButton.setBorder(BorderFactory.createLineBorder( TFIELD_BORDER[guiTheme], BORDER_THICC, true ));

        return newButton;
    }

    /*
     * alternate makeButton for changing width
     */


    /* function for creating a default dark / light mode button
     *  Note: add item listener externally
     *
     * @param int: forms current guiTheme state
     * @param swapInterface: interface implementation containing swap function for current NotSoSimple.form
     * @return JToggleButton: created and formatted button
     */

    /*
     * alternate theme button for different window size
     */

    /* function for creating a default error label to show on gui
     *
     * @param int: error message type to show
     * @param int: forms current guiTheme state
     * @param int: x location to show message
     * @param int: y location to show message
     * @param int: type of alignment (from SwingConstants)
     * @return JLabel: created and formatted error label
     */
    public static JLabel makeErrorLabel(int errorMessage, int x, int y, int align) {
        String errText = "No Error Type";

        if (errorMessage-1 < ERR_MSGS.length) {
            errText = ERR_MSGS[errorMessage-1];
        }

        JLabel newErrorLabel = new JLabel(errText);

        newErrorLabel.setBounds(x, y, LABEL_SIZE[0], LABEL_SIZE[1]);
        newErrorLabel.setForeground( Color.RED );
        newErrorLabel.setFont( ERR_FONT );
        newErrorLabel.setHorizontalAlignment(align);

        return newErrorLabel;
    }

}
