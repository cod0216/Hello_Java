package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureExceptionMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = es.submit(new ExCallble());
        sleep(1000);

        try {
            log("future.get() 호 시도, future.state() : ");
            Integer result = future.get();
            log("result value : " + result );
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log("e : " + e);
            Throwable cause = e.getCause();
            log("cause : " + cause);
            e.printStackTrace();
        }


    }
    static class ExCallble implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }
    }
}
