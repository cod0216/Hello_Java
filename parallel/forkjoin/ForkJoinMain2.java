package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static util.MyLogger.*;

public class ForkJoinMain2 {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        int parallelism = ForkJoinPool.commonPool().getParallelism();
        System.out.println("processors = " + processors+ ", parallelism = " + parallelism);
        List<Integer> data = IntStream.rangeClosed(1,8)
                .boxed()
                .toList();

        log("[생성] " + data);

        // ForkJoinPool 생성 및 작업 수행

        SumTask task = new SumTask(data);

        // 병렬로 합을 구한 후 결과 출력
        int result = task.invoke();
        log("최종 결과: " + result);
    }
}
