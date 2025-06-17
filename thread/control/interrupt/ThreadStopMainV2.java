package thread.control.interrupt;

import util.MyLogger;

import static util.ThreadUtils.sleep;

public class ThreadStopMainV2 {
    public static void main(String[] args) {
        MyTask work = new MyTask();
        Thread thread = new Thread(work, "work");
        thread.start();

        sleep(4000);
        MyLogger.log("작업 중지 요청 Interrupt");
        thread.interrupt();
        MyLogger.log("인터럽트 상태 " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            try {
                while(true) {
                    MyLogger.log("작업 중");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                MyLogger.log("work 스레드 인터럽트 상태 = " + Thread.currentThread().isInterrupted() );
                MyLogger.log("interrupt Message() = " + e.getMessage());
                MyLogger.log("Thread State() = " + Thread.currentThread().getState());
            }
            MyLogger.log("자원 정리");
            MyLogger.log("자원 종료");

        }
    }
}
