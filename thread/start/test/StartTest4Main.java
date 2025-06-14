package thread.start.test;

import util.MyLogger;

public class StartTest4Main {
    public static void main(String[] args) {
        PrintWork task1 = new PrintWork(1000,'A');
        PrintWork task2 = new PrintWork(500,'B');

        Thread threadA = new Thread(task1);
        threadA.start();
        Thread threadB = new Thread(task2);
        threadB.start();
    }
    static class PrintWork implements Runnable{
        int time;
        char print;

        public PrintWork(int time, char print){
            this.time = time;
            this.print = print;
        }

        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(time);
                    MyLogger.log(print);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
