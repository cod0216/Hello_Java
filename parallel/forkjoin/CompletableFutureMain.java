package parallel.forkjoin;

import util.MyLogger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static util.MyLogger.*;

public class CompletableFutureMain {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> log("Fork/Join"));

        ExecutorService es = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(() -> log("Custom Pool"),es);

        Thread.sleep(100);
        es.shutdown();
    }
}
