package NotSoSimple;

import javax.swing.*;

public class breaker1ThreadReckoning {
    static int x = 0;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                /* instantiate a login NotSoSimple.form and show */
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(1));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(2));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(3));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                new Thread(new Runnable() {
                    public void run() {
                        NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(4));
                        C.connect();
                        C.setRoomCode("GLOBAL");
                        int y = 1000;
                        for (x = 0; x < y; x++) {
                            try {
                                Thread.sleep((int) (Math.random()*1000));
                                C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }
                }).start();
                /*ThreadGroup tg = new ThreadGroup("ThreadGroup");
``
                int i = 5;
                for (x = 0; x < i; x++) {
                    try {
                        Thread.sleep((int) (Math.random()*10000));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    new Thread(tg,new Runnable() {

                        public void run() {
                            NotSoSimpleClient C = new NotSoSimpleClient(commonconstants.PORT,Integer.toString(x));
                            C.connect();
                            C.setRoomCode("GLOBAL");
                            int y = 1000;
                            for (x = 0; x < y; x++) {
                                try {
                                    Thread.sleep((int) (Math.random()*1000));
                                    C.sendMessage(Integer.toString(x), commonconstants.reqCodes.NONE, "", "");
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                            }
                        }
                    }).start();

                }*/
            }
        });
    }
}
