package thread.bounded;

import util.MyLogger;
import util.ThreadUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV2 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while(queue.size() == max){
            MyLogger.log("[put] 큐가 가득 참, 대기");
            ThreadUtils.sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while(queue.isEmpty()) {
            MyLogger.log("[take] 쿠에 데이터 없음, 소비자 대기");
            ThreadUtils.sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        // toString도 sychronized 를 원래는 붙혀줘야 된다.
        return queue.toString();
    }
}
