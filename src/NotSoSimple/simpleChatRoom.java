package NotSoSimple;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;

public class simpleChatRoom extends form{

    private String code;

    public simpleChatRoom(NotSoSimpleClient client, int err, String code) {

        /* set title bar */
        super("Chat Room", client, 2);
        this.code = code;
        this.addGuiDesign();

        new Thread(new Runnable() {
            public void run() {
                client.listening();
            }
        }).start();
        client.requestLoggedChats(code);
        do {
            System.out.print("");
        } while (client.getRoomCode().equals("WAITING"));
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
        JTextField message = new JTextField();

        componentList.put("Messages", commonconstants.makeScroller(0, formColumns[0], getRowPosition(0) + (commonconstants.FIELD_DIST/2), this.getWidth() - (formColumns[0]*2), 200, messages));
        componentList.put("Message", commonconstants.makeScroller(0, formColumns[0], getRowPosition(0) + (commonconstants.FIELD_DIST/2) + 200, this.getWidth() - (formColumns[0]*2), 20, message));


        client.messageArea = messages;
        client.messageField = message;

        // disconnect
        componentList.put("leaveChat", commonconstants.makeButton("Leave Chat", 0, formColumns[0], commonconstants.WIN_SIZE[1] - commonconstants.BUTTON_SIZE[1] - 70,0));

        // upload file
        componentList.put("uploadFile", commonconstants.makeButton("Upload File", 0, formColumns[1], commonconstants.WIN_SIZE[1] - commonconstants.BUTTON_SIZE[1] - 70,0));

        // listeners

        componentList.get("leaveChat").addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /*

                    close this open home page

                 */

                /* Notify server that client has left */
                client.sendMessage("Has left the chat", commonconstants.reqCodes.LEAVE, "", "");

                /* Reset field, area, code */
                client.messageArea.setText("");
                client.messageField.setText("");
                client.setRoomCode("");

                new NotEvenCloseToSimpleSelectionPage(client,0).setVisible(true);  // THIS MIGHT GIVE PROBLEMS AS VALIDATIOPN ON CONNECTION NOT REDONE PROPERLY
                simpleChatRoom.this.dispose();
            }
        });

        componentList.get("uploadFile").addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                /* Method for choosing and uploading a file to the server */
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(simpleChatRoom.this);

                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();

                    client.sendFile(selectedFile);
                }
            }
        });

        message.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                client.sendMessage(message.getText(), commonconstants.reqCodes.NONE,"","");
                message.setText(null);
            }
        });


        addComponents();
    }


}