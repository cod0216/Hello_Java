package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

public class CallableMainV1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        MyLogger.log("resule = " + result);
        es.shutdownNow();



    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            MyLogger.log("Callable 시작");
            ThreadUtils.sleep(2000);
            int value = new Random().nextInt(10);
            MyLogger.log("Callable 종료");
            return value;
        }
    }
}
