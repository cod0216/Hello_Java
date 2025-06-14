package thread.start.test;

import util.MyLogger;

public class StartTest3Main {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <=5 ; i++) {
                    try {
                        Thread.sleep(1000);
                        MyLogger.log(i);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

}
