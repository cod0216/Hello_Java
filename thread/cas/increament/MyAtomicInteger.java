package thread.cas.increament;

import java.util.concurrent.atomic.AtomicInteger;

public class MyAtomicInteger implements IncreamentInteger{
    AtomicInteger value = new AtomicInteger(0);

    @Override
    public void increament() {
        value.incrementAndGet();
    }

    @Override
    public int get() {
        return value.get();
    }
}
