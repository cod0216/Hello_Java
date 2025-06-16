package thread.control.join;

import util.MyLogger;
import util.ThreadUtils;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("Start()");
        SumTask task1 = new SumTask(1,50);

        Thread thread1 = new Thread(task1, "thread-1");

        thread1.start();

        MyLogger.log("main Thread watting for thread1 end");
        thread1.join(1000);
        MyLogger.log("main Thread watting end");



        MyLogger.log("task1 result = " + task1.result);

        int sumAll = task1.result;
        MyLogger.log("sumAll = " + sumAll);

        MyLogger.log("End()");
    }

    static class SumTask implements Runnable {
        int startValue;
        int endValue;
        int result;

        public SumTask (int startValue, int endValue){
            this.startValue = startValue;
            this.endValue = endValue;
        }
        @Override
        public void run() {
            MyLogger.log("작업 시작");
            ThreadUtils.sleep(2000);
            for (int i = startValue; i <= endValue; i++) {
                result += i;
            }
            MyLogger.log("작업 종료, resule = " + result);

        }
    }
}
