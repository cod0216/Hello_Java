package thread.cas.increament;

public class IncreamentPerformanceMain {
    public static final long COUNT = 100_000_000;
    public static void main(String[] args) {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SynchronizedInteger());
        test(new MyAtomicInteger());
    }
    private static void test(IncreamentInteger increamentInteger){
        long startMs = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            increamentInteger.increament();
        }
        
        long endMs = System.currentTimeMillis();
        System.out.println(increamentInteger.getClass().getSimpleName() + " : ms = " + (endMs-startMs));
    }

}
