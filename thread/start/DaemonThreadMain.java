package thread.start;

public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        DaemonThread daemonThread = new DaemonThread();
        System.out.println(daemonThread.currentThread().getName() + " :  start() 호출 전");
        daemonThread.setDaemon(true);
        daemonThread.start();
        System.out.println(daemonThread.currentThread().getName() + " :  start() 호출 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");

    }

    static class DaemonThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " : start" );
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " : end" );
        }
    }

}
