package thread.control.interrupt;

import util.MyLogger;
import util.ThreadUtils;

import static util.ThreadUtils.sleep;

public class ThreadStopMainV1 {
    public static void main(String[] args) {
        MyTask work = new MyTask();
        Thread thread = new Thread(work, "work");
        thread.start();

        sleep(4000);
        MyLogger.log("Thread Flag == false");
        work.runFlag = false;

    }

    static class MyTask implements Runnable {

        volatile boolean runFlag = true;

        @Override
        public void run() {
            while(runFlag){
                MyLogger.log("작업 중");
                sleep(3000);

            }
            MyLogger.log("자원 정리");
            MyLogger.log("자원 종료");
        }
    }
}
