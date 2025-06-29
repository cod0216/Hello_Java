package thread.bounded;

import util.MyLogger;
import util.ThreadUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV3 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while(queue.size() == max){
            MyLogger.log("[put] 큐가 가득 참, 대기");
            try {
                wait(); // RUNNABLE() -> WAITING, 락 반남
                MyLogger.log("[put] 생산자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.offer(data);
        MyLogger.log("[put] 생산자 데이터 저장, notify() 호출");
        notify();// 대기상태 -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            MyLogger.log("[take] 쿠에 데이터 없음, 소비자 대기");
            try {
                wait();
                MyLogger.log("[take] 소비자 깨어남");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        String data = queue.poll();
        MyLogger.log("[take] 소비자 데이터 획득, notify() 호출");
        notify(); // 대기 스레드, WAIT -> BLOCKED
        return data;
    }

    @Override
    public String toString() {
        // toString도 sychronized 를 원래는 붙혀줘야 된다.
        return queue.toString();
    }
}
