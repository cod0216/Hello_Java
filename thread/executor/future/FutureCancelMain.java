package thread.executor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class FutureCancelMain {

//    private static boolean mayInterruterIfRunning = true;
    private static boolean mayInterruterIfRunning = false;

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<String> future = es.submit(new MyTask());

        sleep(3000);

//        MyLogger.log("futuer.state : " + future.state());

        //cancel
        log("future.cancel(" + mayInterruterIfRunning + ") 호출");
        boolean result = future.cancel(mayInterruterIfRunning);
        log("future.cancel(" + mayInterruterIfRunning + "). result = " + result);

        try {
            log("Future result : " + future.get());
        } catch (CancellationException e){
            log("Future는 이미 취소 되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }


    }

    static class MyTask implements Callable<String>{
        @Override
        public String call() throws Exception {

            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중 " + i);
                    Thread.sleep(1000);

                }
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

            return "Completed";
        }
    }
}
