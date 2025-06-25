package thread.lock;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new ParkTest(), "parkThread");
        t1.start();

        ThreadUtils.sleep(100);
        MyLogger.log("thread-1 state : " + t1.getState());
        MyLogger.log("main -> unpark(thread1)");
    }



    static class ParkTest implements Runnable {
        @Override
        public void run() {
            MyLogger.log("park 시작");
            LockSupport.parkNanos(2000_000000);
            MyLogger.log("park 종료, state : " + Thread.currentThread().getState());
            MyLogger.log("인터럽스 상태 : " + Thread.currentThread().isInterrupted());
        }
    }
}
