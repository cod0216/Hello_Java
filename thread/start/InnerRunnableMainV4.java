package thread.start;

import static util.MyLogger.*;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");
        Thread thread =new Thread(() ->
                log("run()")

        );
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



