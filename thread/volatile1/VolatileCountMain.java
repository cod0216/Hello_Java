package thread.volatile1;

import util.MyLogger;
import util.ThreadUtils;

public class VolatileCountMain {
    public static void main(String[] args) {
        MyTask work = new MyTask();
        Thread t1 = new Thread(work, "work");

        t1.start();
        ThreadUtils.sleep(1000);
        work.flag = false;
        MyLogger.log("flag = " + work.flag + ", count = " +work.count + " in main");
    }
    static class MyTask implements Runnable{
        boolean flag = true;
        int count;

//00:12:18.061 [     work] flag = true, count = 300000000 in while()
//00:12:18.064 [     work] flag = false, count = 300000000 종료



//        volatile boolean flag = true;
//        volatile int count;

//00:09:10.846 [     main] flag = false, count = 96301159 in main
//00:09:10.848 [     work] flag = false, count = 96301159 종료
        @Override
        public void run() {
            while(flag) {
                count++;
                if(count % 100_000_000 == 0) {
                    MyLogger.log("flag = " + flag + ", count = " + count + " in while()");
                }
            }
            MyLogger.log("flag = " + flag + ", count = " + count + " 종료");

        }
    }
}

