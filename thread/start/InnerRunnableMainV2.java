package thread.start;

import static util.MyLogger.*;

public class InnerRunnableMainV2 {
    public static void main(String[] args) {
        log("main() start");
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                log("run()");
            }
        };
        Thread thread =new Thread(runnable);
        thread.start();
        log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            log("run()");
        }
    }

}



