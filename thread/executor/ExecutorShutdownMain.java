package thread.executor;

import util.MyLogger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static thread.executor.ExecutorUtils.printState;
import static util.MyLogger.log;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        es.submit(new RunnableTask("taskA"));
        es.submit(new RunnableTask("taskB"));
        es.submit(new RunnableTask("taskC"));
        es.submit(new RunnableTask("longTask" ,100_000 ));
        printState(es);
        log("=========== Shutdown 시작 ============");
        shutdownAndAwaitTermination(es);
        log("=========== Shutdown 완료 ============");
        printState(es);

    }

    private static void shutdownAndAwaitTermination(ExecutorService es){
        es.shutdown(); // non-blocking, 새로운 작업을 받지 않는다. 처리 중이거나, 큐에 이미 대기중인 작업은 처리한다. 이후에 풀의 스레드를 종료한다.
        try {

            // 이미 대기중인 작업들을 모두 완료할 때 까지 10초 기다린다.
            if(!es.awaitTermination(10, TimeUnit.SECONDS)){
                // 정상 종료가 너무 오래 걸리면...
                    log("서비서 정상 종료 실패 -> 강제 종료 시도");
                    es.shutdownNow();
                    if(!es.awaitTermination(10,TimeUnit.SECONDS)){
                        log("서비스가 종료되지 않았습니다.");
                    }
                log("서비스가 종료되었습니다.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
