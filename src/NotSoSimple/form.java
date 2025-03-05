package NotSoSimple;

import javax.swing.*;
import javax.swing.text.JTextComponent;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Map;
import java.util.HashMap;

/* general class for each gui NotSoSimple.form */
public abstract class form extends JFrame {

    /* global theme and component list for gui */
    public NotSoSimpleClient client;
    public  Map<String, JComponent> componentList;
    public Map<String, JTextComponent> textComponentList;
    public static int[] formColumns;

    /* constructor */
    public form(String title, NotSoSimpleClient _client, int _columns) {

        /* set title bar */
        super(title);

        /* set default window size and close operation */
        setSize( commonconstants.WIN_SIZE[0], commonconstants.WIN_SIZE[1] );
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        addWindowListener( new WindowAdapter() {
            public void windowClosing(WindowEvent e) {

            }
        });

        /* disable layout management to use absolute positioning */
        setLayout(null);

        /* load window in center of screen, prevent resizing */
        setResizable(false);

        client = _client;
        componentList = new HashMap<>();
        textComponentList = new HashMap<>();

        formColumns = calculateCols(_columns);


    }


    public abstract void addGuiDesign();

    /* add all components from componentList to the NotSoSimple.form
     *
     * @return void
     */
    public void addComponents() {
        for (JComponent component : componentList.values()) {
            add(component);
        }

        for (JTextComponent component : textComponentList.values()) {
            add(component);
        }
    }

    /* comment pls */
    public int[] calculateCols(int columnCount) {
        int offset = 40;

        int[] colCalculations = new int[columnCount];

        for (int i = 0; i < columnCount; i++) {
            colCalculations[i] = offset + ((this.getWidth() / columnCount) * i);
        }

        return colCalculations;
    }

    /* swap gui theme when button toggled, and update
     *
     * swap interface implementation
     */

    /* reset username and completely log out of any current NotSoSimple.form
     *
     * @return void
     */

    /* calculate the row position for an int row, based on set sizing
     *
     * @param int: row to calculate
     * @return int: y position of row
     */
    public int getRowPosition(int row) {
        return 70 + (90*row);
    }

    /* Check if text component list contains empty
     *
     * @param Map<String, JTextComponent>: list of type textComponentList
     * @return Boolean: is there an empty text field
     */
    public boolean containsEmpty(Map<String, JTextComponent> list) {
        for (String key : list.keySet()) {
            if (list.get(key).getText().isEmpty()) {
                return true;
            }
        }

        return false;
    }

    /*
     * Safely close the HSPS system
     */
}
