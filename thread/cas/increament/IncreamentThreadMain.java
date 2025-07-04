package thread.cas.increament;

import util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class IncreamentThreadMain {
    public static final int THREAD_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SynchronizedInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncreamentInteger increamentInteger) throws InterruptedException {

        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                ThreadUtils.sleep(10); // 너무 빨리 실행되기 때문에, 다른 스레드와 동시 실행을 위해 잠깐 쉬었다 실행
                increamentInteger.increament();
            }
        };

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new Thread(runnable);
            threadList.add(thread);
            thread.start();
        }

        for (Thread thread : threadList) {
            thread.join();
        }

        int result = increamentInteger.get();
        System.out.println(increamentInteger.getClass().getSimpleName() + " : " + result);


    }
}
