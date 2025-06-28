package thread.bounded;

import util.MyLogger;
import util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain {
    public static void main(String[] args) {

        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV2(2);

        // 2. 생산자, 소비자 실행 순서 선택, 반드 하나만 선택!
//        producerFirst(queue);
        consumerFirst(queue);
    }

    private static void producerFirst(BoundedQueue queue){
        MyLogger.log("== [생산자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + "  == ");
        List<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        printAllState(queue, threads);
        startConsumer(queue, threads);
        printAllState(queue, threads);
        MyLogger.log("== [생산자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + "  == ");
    }

    private static void consumerFirst(BoundedQueue queue){
        MyLogger.log("== [소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + "  == ");
        List<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllState(queue, threads);
        startProducer(queue, threads);
        printAllState(queue, threads);
        MyLogger.log("== [소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + "  == ");
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        MyLogger.log("소비자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            ThreadUtils.sleep(100);
        }
    }

    private static void startProducer(BoundedQueue queue, List<Thread> threads){
        System.out.println();
        MyLogger.log("생성자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "proudcer" + i);
            threads.add(producer);
            producer.start();
            ThreadUtils.sleep(100);
        }
    }
    private static void printAllState(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        MyLogger.log("현제 상태 출력, 큐 데이터 : " + queue);
        for(Thread thread : threads) {
            MyLogger.log(thread.getName() + ": " + thread.getState());
        }

    }
}
