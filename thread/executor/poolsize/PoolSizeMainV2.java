package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;
import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
//        ExecutorService es1 =  new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        log("Pool 생성");
        printState(es);

        for (int i = 1; i <= 6; i++) {
            String threadName = "task_" + i;
            es.execute(new RunnableTask(threadName));
            printState(es);
        }

        es.shutdown();
    }
}
