package thread.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloRunnable helloRunnable = new HelloRunnable();

        Thread thread = new Thread(helloRunnable);


        System.out.println(Thread.currentThread().getName() + ": main() start");
    }
}
