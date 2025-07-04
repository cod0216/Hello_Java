package thread.cas.increament;

public class SynchronizedInteger implements IncreamentInteger{
    private int value;

    @Override
    public synchronized void increament() {
        value++;
    }

    @Override
    public synchronized int get() {
        return value;
    }
}
