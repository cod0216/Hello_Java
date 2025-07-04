package thread.cas.spinlock;

import util.MyLogger;
import util.ThreadUtils;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLockBad = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

         Runnable task = new Runnable() {
            @Override
            public void run() {
                spinLock.lock();
                try{
                    MyLogger.log("비즈니스 로직 실행");
                }finally {
                    spinLock.unlock();
                }
            }
        };

         Thread t1 = new Thread(task);
         Thread t2 = new Thread(task);

         t1.start();
         t2.start();
    }
}
