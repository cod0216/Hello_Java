package thread.control.join;

import util.MyLogger;
import util.ThreadUtils;

public class JoinMainV3 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("Start()");
        SumTask task1 = new SumTask(1,50);
        SumTask task2 = new SumTask(51,100);

        Thread thread1 = new Thread(task1, "thread-1");
        Thread thread2 = new Thread(task2, "thread-2");

        thread1.start();
        thread2.start();

        MyLogger.log("main Thread watting for thread1, thread2 end");
        thread1.join();
        thread2.join();
        MyLogger.log("main Thread watting end");



        MyLogger.log("task1 result = " + task1.result);
        MyLogger.log("task2 result = " + task2.result);

        int sumAll = task1.result + task2.result;
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
