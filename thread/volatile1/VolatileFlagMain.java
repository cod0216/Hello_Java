package thread.volatile1;

import collection.map.test.Task;
import util.MyLogger;
import util.ThreadUtils;

public class VolatileFlagMain {
    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task);
        MyLogger.log("스래드 스타트!");
        thread.start();
        ThreadUtils.sleep(1000);
        MyLogger.log("runFlag --> false");
        task.runFlag = false;
        MyLogger.log("main Thread 종료");


    }
    static class MyTask implements Runnable {
        boolean runFlag = true;

        @Override
        public void run() {
            MyLogger.log("task 시작");
            while(runFlag) {
                System.out.println("Thread - 작업 중");
            }
            MyLogger.log("task 종료");

        }
    }
}
