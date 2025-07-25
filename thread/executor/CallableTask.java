package thread.executor;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.Callable;

import static util.MyLogger.log;
import static util.ThreadUtils.sleep;

public class CallableTask implements Callable<Integer> {
    private String name;
    private int sleepMs;

    public CallableTask(String name) {
        this.name = name;
    }

    public CallableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }


    @Override
    public Integer call() throws Exception {
        log(name+ " 실행");
        sleep(sleepMs);
        log(name+ " 완료");
        return sleepMs;
    }
}
