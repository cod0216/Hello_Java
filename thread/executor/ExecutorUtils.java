package thread.executor;

import util.MyLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorUtils {
    public static void printState(ExecutorService executorService){
        if(executorService instanceof ThreadPoolExecutor threadPoolExecutor){
            int pool = threadPoolExecutor.getPoolSize();
            int active = threadPoolExecutor.getActiveCount();
            int queue = threadPoolExecutor.getQueue().size();
            long completeTask = threadPoolExecutor.getCompletedTaskCount();

            MyLogger.log("[pool=" + pool + ", active=" + active + ", queueTasks=" + queue + ", completedTask=" + completeTask + "]");

        } else {
            MyLogger.log(executorService);
        }
    }
}
