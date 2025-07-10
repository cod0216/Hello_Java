package thread.collection.simple.list;

import util.MyLogger;

import java.util.Collections;

import static util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1 : list.add(A)");


            }
        };
        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2 : list.add(B)");

            }
        };

        Thread threadA = new Thread(addA, "thread-A");
        Thread threadB = new Thread(addB, "thread-B");

        threadA.start();
        threadB.start();

        threadA.join();
        threadB.join();

        log(list);

    }
}
