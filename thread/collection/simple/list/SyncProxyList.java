package thread.collection.simple.list;

public class SyncProxyList implements SimpleList {

    private SimpleList targe;

    public SyncProxyList(SimpleList targe) {
        this.targe = targe;
    }

    @Override
    public synchronized int size() {
        return targe.size();
    }

    @Override
    public synchronized void add(Object e) {
        targe.add(e);
    }

    @Override
    public String toString() {
        return targe.toString() + " by " + this.getClass().getSimpleName();
    }
}
