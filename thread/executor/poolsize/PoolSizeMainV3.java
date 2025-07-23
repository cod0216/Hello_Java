package thread.executor.poolsize;

import thread.executor.RunnableTask;
import util.ThreadUtils;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV3 {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
        log("Pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String threadName = "task_" + i;
            es.execute(new RunnableTask(threadName));
            printState(es);
        }


        ThreadUtils.sleep(3000);
        printState(es);

        ThreadUtils.sleep(3000);
        printState(es);

        es.shutdown();
    }
}
