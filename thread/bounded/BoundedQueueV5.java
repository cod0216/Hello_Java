package thread.bounded;

import util.MyLogger;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueueV5 implements BoundedQueue{

    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition(); // 여기가 대기 집합이 된다.
    private final Condition consumerCond = lock.newCondition(); // 여기가 대기 집합이 된다.


    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try{
            while(queue.size() == max){
                MyLogger.log("[put] 큐가 가득 참, 대기");
                try {
                    producerCond.await();// 스레드가 기대리는 대기 집합
                    MyLogger.log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data);
            MyLogger.log("[put] 생산자 데이터 저장, consumerCond.signal() 호출");
            consumerCond.signal(); // 대기 집합에 신호를 준다.
        }finally {
            lock.unlock();
        }
        // 자바가 제공하는 기본 객체 안에서 기다리냐 아니면 condition안에서 기다리냐 차이
    }

    @Override
    public String take() {
        lock.lock();
        try{
            while(queue.isEmpty()) {
                MyLogger.log("[take] 쿠에 데이터 없음, 소비자 대기");
                try {
                    consumerCond.await();
                    MyLogger.log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            MyLogger.log("[take] 소비자 데이터 획득, producerCond.signal() 호출");
            producerCond.signal();
            return data;

        }finally {
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        // toString도 sychronized 를 원래는 붙혀줘야 된다.
        return queue.toString();
    }
}
