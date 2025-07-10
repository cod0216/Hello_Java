package thread.executor;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2,2,0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        MyLogger.log("============초기상태============");
        ExecutorUtils.printState(es);
        es.execute(new RunnableTask("tastA"));
        es.execute(new RunnableTask("tastB"));
        es.execute(new RunnableTask("tastC"));
        es.execute(new RunnableTask("tastD"));
        MyLogger.log("============수행 중============");
        ExecutorUtils.printState(es);
        ThreadUtils.sleep(3000);
        MyLogger.log("============작업 수행 완료============");
        ExecutorUtils.printState(es);


        es.shutdownNow();
        MyLogger.log("============shutdown 완료============");
        ExecutorUtils.printState(es);


    }
}
