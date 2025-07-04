package thread.cas.spinlock;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {
    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        MyLogger.log("락 획득 시도");
        while(!lock.compareAndSet(false,true)){
            // 락을 획득할 때까지 핀 대기
            MyLogger.log("락 획득 실패 - 스핀 대기");
        }
        MyLogger.log("락 획득 완료");
    }

    public void unlock(){
        lock.set(false);
        MyLogger.log("락 반납 완료");
    }
}
