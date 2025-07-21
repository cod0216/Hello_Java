package thread.executor;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static util.MyLogger.log;

public class InvokeAnyMain {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
       ExecutorService es = Executors.newFixedThreadPool(10);

       CallableTask task1 = new CallableTask("task1", 1000);
       CallableTask task2 = new CallableTask("task2", 2000);
       CallableTask task3 = new CallableTask("task3", 3000);
       List<CallableTask> list = List.of(task1,task2,task3);

       Integer result = es.invokeAny(list);
       log("완료 되기 전에는 나오면 안되는 Log");

       log("result : " + result);
        es.shutdown();
    }

}
