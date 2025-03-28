package NotSoSimple;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class NotSoSimpleClientLoginPage extends form{
    int err;
    public NotSoSimpleClientLoginPage(NotSoSimpleClient client, int err) {

        /* set title bar */
        super("Connect", client, 2);

        NotSoSimpleClient CLIENT = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
        CLIENT.connect();
        this.client = CLIENT;
        this.err = err;

        this.addGuiDesign();
    }

    /* add gui components to the NotSoSimple.form */
    public void addGuiDesign() {

        /* set background color based on theme */
        getContentPane().setBackground( commonconstants.BG_COLOR[0] );

        /* create title, labels, fields, and buttons, and add to component list */
        componentList.put("Title", commonconstants.makeTitle("DISCORD", 0));

        componentList.put("uNameHead", commonconstants.makeSubheading("Display Name", 0, formColumns[0], getRowPosition(0), SwingConstants.LEFT));

        textComponentList.put("uNameField", commonconstants.makeTextField(0, formColumns[0], getRowPosition(0) + commonconstants.FIELD_DIST, false));

        componentList.put("uPWordHead", commonconstants.makeSubheading("Password", 0, formColumns[0], getRowPosition(1), SwingConstants.LEFT));

        textComponentList.put("uPWordField", commonconstants.makeTextField(0, formColumns[0], getRowPosition(1) + commonconstants.FIELD_DIST, true));

        if(err ==1){
            componentList.put("err1",commonconstants.makeErrorLabel(8,formColumns[0],getRowPosition(1) + 100,SwingConstants.LEFT));
        }
        if(err ==2){
            componentList.put("err1",commonconstants.makeErrorLabel(7,formColumns[0],getRowPosition(1) + 100,SwingConstants.LEFT));
        }

        componentList.put("loginButton", commonconstants.makeButton("Connect To Chat Server", 0, formColumns[0], commonconstants.WIN_SIZE[1] - 80 - commonconstants.BUTTON_SIZE[1],100));

        componentList.put("regButton", commonconstants.makeButton("Register", 0, formColumns[1], commonconstants.WIN_SIZE[1] - 80 - commonconstants.BUTTON_SIZE[1],60));




        componentList.get("loginButton").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        /*

                                DO CONNECTION STUFF HERE THEN IF CONNECT SHOW 'HOME' PAGE

                         */
                        new Thread(new Runnable() {
                            public void run() {
                                client.listening();
                            }
                        }).start();
                        String loginName = textComponentList.get("uNameField").getText();
                        String loginPassword = textComponentList.get("uPWordField").getText();
                        if(!loginName.isEmpty() && !loginPassword.isEmpty()) {
                            client.checkNameAndPassword(loginName, loginPassword);
                            do {System.out.print("");} while (client.getRoomCode().equals("WAITING"));
                            if(client.getRoomCode().equals("T")) {
                                client.clientName = loginName;
                                new NotEvenCloseToSimpleSelectionPage(client, 0).setVisible(true);
                                NotSoSimpleClientLoginPage.this.dispose();
                                return;
                            }
                        }
                        new NotSoSimpleClientLoginPage(client,1).setVisible(true);
                        NotSoSimpleClientLoginPage.this.dispose();

                    }
                }
        );

        componentList.get("regButton").addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        new Thread(new Runnable() {
                            public void run() {
                                client.listening();
                            }
                        }).start();
                        String registerName = textComponentList.get("uNameField").getText();
                        String registerPassword = textComponentList.get("uPWordField").getText();
                        if(!registerName.isEmpty() && !registerPassword.isEmpty()) {
                            client.checkNameNotUsed(registerName, registerPassword);
                            do {
                                System.out.print("");
                            } while (client.getRoomCode().equals("WAITING"));
                            try {
                                TimeUnit.MILLISECONDS.sleep(10);
                            } catch (InterruptedException ee) {
                                throw new RuntimeException(ee);
                            }
                            if (client.getRoomCode().equals("T")) {
                                client.clientName = registerName;
                                new NotEvenCloseToSimpleSelectionPage(client, 0).setVisible(true);
                                NotSoSimpleClientLoginPage.this.dispose();
                                return;
                            }
                        }
                        new NotSoSimpleClientLoginPage(client,2).setVisible(true);
                        NotSoSimpleClientLoginPage.this.dispose();
                    }
                }
        );

        /* add components to NotSoSimple.form */
        addComponents();
    }

    int loginValidation(String enteredUname, String enteredPassword) {
        if ( enteredUname.isEmpty() || enteredPassword.isEmpty() ) { return commonconstants.EMPTY_ERR; }


        int loginType = commonconstants.FAILED;
        if ( loginType == commonconstants.FAILED ) { return commonconstants.LOGIN_ERR; }


        return loginType;
    }

    public String bensWonderfulFunction(){
        String code = "";
        for(int counter = 0; counter < 21; counter++) {

            int randomNum = (int) (Math.random() * 10);
            int randomLet = (int) (Math.random() * 26);
            int letOrNum = (int) (Math.random() * 2);
            if (letOrNum == 0) {
                char c = (char) (randomNum + 48);
                code = code + c;
            }else{
                char c = (char)(randomNum + 65);
                code = code + c;
            }
        }
        return code;
    }

}
