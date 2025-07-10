package thread.executor.future;

import thread.executor.MyRunnable;
import util.MyLogger;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        MyRunnable task = new MyRunnable();
        Thread thread = new Thread(task, " Thread-1");
        thread.start();
        thread.join();
        int result = task.value;
        MyLogger.log("result value = " + result);
    }
}
