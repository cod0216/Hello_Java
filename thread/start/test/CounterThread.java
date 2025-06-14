package thread.start.test;

import util.MyLogger;

public class CounterThread extends Thread {
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
}
