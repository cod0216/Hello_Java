package thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {
    private BlockingQueue<String> queue;

    public BoundedQueueV6_4(int max) {
        queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        queue.add(data); // java.lang.IllegalStateException: Queue.full
    }

    @Override
    public String take() {
        return queue.remove(); // java.util.NoSuchElementEception
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
