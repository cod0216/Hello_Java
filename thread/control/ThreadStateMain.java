package thread.control;

import util.MyLogger;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyRunnable());
        MyLogger.log("myThread state1 = ß" + thread.getState());
        MyLogger.log("myThread start()");
        thread.start();
        Thread.sleep(1000);
        MyLogger.log("myThread getState() = " + thread.getState());
        Thread.sleep(3000);
        MyLogger.log("myThread getState() = " + thread.getState());


    }
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            try {
                MyLogger.log("start");
                MyLogger.log("myRunnable state = " + Thread.currentThread().getState());
                MyLogger.log("myRunnable sleep start()");
                Thread.sleep(3000);
                MyLogger.log("myRunnable state = " + Thread.currentThread().getState());
                MyLogger.log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/*
18:06:40.847 [     main] myThread state1 = ßNEW
18:06:40.861 [     main] myThread start()
18:06:40.862 [ Thread-0] start
18:06:40.862 [ Thread-0] myRunnable state = RUNNABLE
18:06:40.863 [ Thread-0] myRunnable sleep start()
18:06:41.867 [     main] myThread getState() = TIMED_WAITING
18:06:43.871 [ Thread-0] myRunnable state = RUNNABLE
18:06:43.873 [ Thread-0] end
18:06:44.870 [     main] myThread getState() = TERMINATED
 */

