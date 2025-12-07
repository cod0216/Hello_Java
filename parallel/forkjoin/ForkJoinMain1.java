package parallel.forkjoin;

import util.MyLogger;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.*;

public class ForkJoinMain1 {
    public static void main(String[] args) {
        List<Integer> data = IntStream.rangeClosed(1,8)
                .boxed()
                .toList();

        log("[생성] " + data);

        // ForkJoinPool 생성 및 작업 수행
        ForkJoinPool pool = new ForkJoinPool(2);

        long start = System.currentTimeMillis();
        SumTask task = new SumTask(data);

        // 병렬로 합을 구한 후 결과 출력
        int result = pool.invoke(task);
        pool.shutdown();
        long end = System.currentTimeMillis();
        log("time: " + (end - start) + "ms, sum : " + result);
        log("pool : " + pool);
    }
}
