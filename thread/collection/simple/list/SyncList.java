package thread.collection.simple.list;

import util.ThreadUtils;

import java.util.Arrays;

public class SyncList implements SimpleList{

    public static final int DEFALUT_CAPACITY = 5;

    private Object[] elements;
    private int size = 0;

    public SyncList() {
        this.elements = new Object[DEFALUT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object e) {
        elements[size] = e;
        ThreadUtils.sleep(100);//멀티스레드 문제를 쉽게 확인하는 코드
        size++;
    }

    public synchronized Object get(int index){
        return elements[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size)) + " size = " + size + ", capacity = " + elements.length;
    }
}
