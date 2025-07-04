package thread.cas.increament;

public class BasicInteger implements IncreamentInteger{
    private int value;

    @Override
    public void increament() {
        value++;
    }

    @Override
    public int get() {
        return value;
    }
}
