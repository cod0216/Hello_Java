package thread.sync.test;

import util.MyLogger;

public class SyncTest2Main {
    public static void main(String[] args) {
        MyCounter myCounter = new MyCounter();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                myCounter.count();
            }
        };

        Thread t1 = new Thread(task, "thread-1");
        Thread t2 = new Thread(task, "thread-2");

        t1.start();
        t2.start();


    }

    static class MyCounter {
        public void count() {
            int localValue = 0;
            for (int i = 0; i < 1000; i++) {
                localValue = localValue + 1;
            }
            MyLogger.log("결과 : " + localValue);
        }
    }
}
