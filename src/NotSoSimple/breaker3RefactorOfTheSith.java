package NotSoSimple;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class breaker3RefactorOfTheSith {

    public static String bensWonderfulFunction(){
        String code = "";
        String[] characters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
                ,"0","1","2","3","4","5","6","7","8","9"};
        for(int counter = 0; counter < 21; counter++) {

            int randomNum = (int) (Math.random() * 36);
            code += characters[randomNum];
        }
        return code;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,bensWonderfulFunction());
                        C.connect();
                        new Thread(new Runnable() {
                            public void run() {
                                C.listening();
                            }
                        }).start();
                        C.checkNameNotUsed(C.clientName,"123");
                        do{
                            System.out.print("");
                        }while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        C.requestChatBreaker();
                        do {
                            System.out.print("");
                        } while (C.getRoomCode().equals("WAITING"));
                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException ee) {
                            throw new RuntimeException(ee);
                        }
                        if(C.getRoomCode().equals("test")) {
                            System.out.println("My room is test");
                        }else{
                            System.out.println("My room is not test");
                        }
                    }
                }).start();
            }
        });
    }
}
