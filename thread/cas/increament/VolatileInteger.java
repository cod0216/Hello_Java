package thread.cas.increament;

public class VolatileInteger implements IncreamentInteger{
    private volatile int value;

    @Override
    public void increament() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
