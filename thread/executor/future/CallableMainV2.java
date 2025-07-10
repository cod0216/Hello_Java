package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

public class CallableMainV2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        MyLogger.log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        MyLogger.log("future 즉시 반환, future = " + future);

        MyLogger.log("future.get() [블로킹] 메서드 호출 시작 -> main 스레드 WATING");
        Integer result = future.get();
        MyLogger.log("future.get() [블로킹] 메서드 호출 완료 -> main 스레드 RUNNABLE");

        MyLogger.log("resule value = " + result);
        MyLogger.log("future 완료, future = " + future);
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
