package thread.control.interrupt;

import util.MyLogger;

import static util.ThreadUtils.sleep;

public class ThreadStopMainV4 {
    public static void main(String[] args) {
        MyTask work = new MyTask();
        Thread thread = new Thread(work, "work");
        thread.start();

        sleep(100);
        MyLogger.log("작업 중지 요청 Interrupt");
        thread.interrupt();
        MyLogger.log("인터럽트 상태 1 " + thread.isInterrupted());

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            while(!Thread.interrupted()) {
                MyLogger.log("작업 중");
            }
            MyLogger.log("work 스레드 인터럽트 상태 = " + Thread.currentThread().isInterrupted() );

            try {
                MyLogger.log("자원 정리");
                Thread.sleep(1000);
                MyLogger.log("자원 정리 완료");
            } catch (InterruptedException e) {
                MyLogger.log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
                MyLogger.log("work 스레드 인터럽트 상태3 = " + Thread.currentThread().isInterrupted());
            }
            MyLogger.log("자원 종료");





        }
    }
}
