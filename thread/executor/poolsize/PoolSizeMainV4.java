package thread.executor.poolsize;

import thread.executor.ExecutorUtils;
import thread.executor.RunnableTask;
import util.MyLogger;

import java.util.concurrent.*;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class PoolSizeMainV4 {

//    static final int TASK_SIZE = 1100; // 1.일반
    static final int TASK_SIZE = 1200; // 2.긴급
//    static final int TASK_SIZE = 1201; // 3.거절
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(100,200,60, TimeUnit.SECONDS,new ArrayBlockingQueue<>(1000));
        printState(es);
        long startMs = System.currentTimeMillis();
        for (int i = 0; i <TASK_SIZE; i++) {
            String name = "task_"+ i;
            try{
                es.execute(new RunnableTask(name));
                printState(es);
            }catch (RejectedExecutionException e){
                log(name + "->" + e);
            }
        }




        es.shutdown();
        long endMs = System.currentTimeMillis();
        log("time : " + (endMs - startMs));
    }

}
