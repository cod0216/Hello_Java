package thread.executor;

import util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import static thread.executor.ExecutorUtils.printState;
import static util.ThreadUtils.sleep;

public class PrestartPoolMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1000);
        printState(es);
        ThreadPoolExecutor thread = (ThreadPoolExecutor) es;
        thread.prestartAllCoreThreads();
        sleep(100);
        printState(es);
        es.shutdown();

    }
}
