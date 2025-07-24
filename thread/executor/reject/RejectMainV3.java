package thread.executor.reject;

import thread.executor.RunnableTask;

import java.util.concurrent.*;

public class RejectMainV3 {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.CallerRunsPolicy());
        es.submit(new RunnableTask("task1"));
        es.submit(new RunnableTask("task2"));
        es.submit(new RunnableTask("task3"));
        es.shutdown();




    }
}
