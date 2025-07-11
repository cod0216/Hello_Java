package thread.bounded;

import util.MyLogger;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV1 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if(queue.size() == max){
            MyLogger.log("[put] 큐가 가득 참, 버림 : " + data);
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if(queue.isEmpty()) return null;
        return queue.poll();
    }

    @Override
    public String toString() {
        // toString도 sychronized 를 원래는 붙혀줘야 된다.
        return queue.toString();
    }
}
