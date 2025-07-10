package thread.executor;

import util.MyLogger;
import util.ThreadUtils;

import java.util.Random;

public class MyRunnable implements Runnable{
    public int value;

    @Override
    public void run() {
        MyLogger.log("Runnable 시작");
        ThreadUtils.sleep(2000);
        value = new Random().nextInt(10);
        MyLogger.log("create value = " + value);
        MyLogger.log("Runnable 완료");

    }
}
