package parallel;

import util.MyLogger;

import java.util.stream.IntStream;

public class ParallelMain1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        int sum = IntStream.rangeClosed(1, 8)
                .map(HeavyJob::headvyTask)
                .reduce(0, (a,b) -> a+b); // sum();

        long endTime = System.currentTimeMillis();

        MyLogger.log("time : " + (endTime - startTime) + "ms, sum : " + sum);

    }
}
