package thread.start.test;

public class StartTest2Main {
    public static void main(String[] args) {
        CounterRunnable task = new CounterRunnable();
        Thread thread = new Thread(task);
        thread.start();
    }

}
