package thread.control.yield;

import util.MyLogger;
import util.ThreadUtils;

public class YieldMain {
    static final int THREAD_COUNT = 1000;
    public static void main(String[] args){
        for(int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(new MyRunnable());
            thread.start();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for(int i = 0; i<10; i++){
                MyLogger.log(Thread.currentThread().getName() + " - " + i);
//                System.out.println(Thread.currentThread().getName() + " - " + i);
//                ThreadUtils.sleep(1);
//                Thread.yield();
            }

        }
    }
}
