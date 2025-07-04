package thread.cas.spinlock;

import util.MyLogger;
import util.ThreadUtils;

public class SpinLockBad {
    private volatile boolean lock = false;

    public void lock() {
        MyLogger.log("락 획득 시도");
        while(true) {
            if(!lock) { // 락 사용 여부 확인
                ThreadUtils.sleep(100); // 문제 상황 확인용
                lock = true; // 락의 값 변경
                break;
            }else {
                // 락을 획득할 때까지 핀 대기
                MyLogger.log("락 획득 실패 - 스핀 대기");
            }
        }
        MyLogger.log("락 획득 완료");
    }

    public void unlock(){
        lock = false;
        MyLogger.log("락 반납 완료");

    }
}
