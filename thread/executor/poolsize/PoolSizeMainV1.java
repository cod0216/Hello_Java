package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;
import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class PoolSizeMainV1 {
    public static void main(String[] args)  {
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ExecutorService es = new ThreadPoolExecutor(2, 4, 3000, TimeUnit.MILLISECONDS, workQueue);
        printState(es);
        es.execute(new RunnableTask("task1"));
        printState(es, "task1");

        es.execute(new RunnableTask("task2"));
        printState(es, "task2");

        es.execute(new RunnableTask("task3"));
        printState(es, "task3");

        es.execute(new RunnableTask("task4"));
        printState(es, "task4");

        es.execute(new RunnableTask("task5"));
        printState(es, "task5");

        es.execute(new RunnableTask("task6"));
        printState(es, "task6");

        try {
            es.execute(new RunnableTask("task7"));
        } catch (RejectedExecutionException e) {
            log("예외 발생 : " + e);
        } finally {

            printState(es, "task7");
        }



        sleep(3000);
        log("====== 작업 완료=====");
        printState(es);

        sleep(3000);
        printState(es);

        es.shutdown();
        log("====== 작업 종료=====");
        printState(es);


    }
}
