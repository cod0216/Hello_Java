package thread.control;

import thread.start.HelloRunnable;
import util.MyLogger;

public class ThreadInfoMain {
    public static void main(String[] args) {
        //main Thread
        Thread mainThread = Thread.currentThread();
        MyLogger.log("main Thread = " + mainThread);
        MyLogger.log("main Thread Id = " + mainThread.threadId()); // Java가 내부적으로 만들어주고 중복되지 않는다.
        MyLogger.log("main Thread Name = " + mainThread.getName()); // 중복 가능
        MyLogger.log("main Thread Priority = " + mainThread.getPriority());
        // 기본이 5고 높을 수록 조금 더 많이 실행하자! 라고 CPU에게 알려준다. --> 무조건은 아니다. (운영체제가 최적화 해주기 때문)
        MyLogger.log("main Thread Group = " + mainThread.getThreadGroup());
        MyLogger.log("main Thread state = " + mainThread.getState()); // RUNNABLE 실행될 수 있는 상

        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        MyLogger.log("myThread Thread = " + myThread);
        MyLogger.log("myThread Thread Id = " + myThread.threadId());
        // 17:07:10.015 [     main] myThread Thread Id = 20
        // 20 -> Java가 임의로 실행 해 준다.
        MyLogger.log("myThread Thread Name = " + myThread.getName());
        MyLogger.log("myThread Thread Priority = " + myThread.getPriority());
        MyLogger.log("myThread Thread Group = " + myThread.getThreadGroup());
        MyLogger.log("myThread Thread state = " + myThread.getState());
        // 17:07:10.019 [     main] myThread Thread state = NEW
        // 생성만 하고 아직 실행은 하지 않은 상태
    }
}
