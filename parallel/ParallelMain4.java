package parallel;

import util.MyLogger;

import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

public class ParallelMain4 {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        int parallelism = ForkJoinPool.commonPool().getParallelism();
        System.out.println("processors = " + processors+ ", parallelism = " + parallelism);
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::headvyTask)
                .reduce(0, (a,b) -> a+b); // sum();

        long endTime = System.currentTimeMillis();

        MyLogger.log("time : " + (endTime - startTime) + "ms, sum : " + sum);

    }
}
