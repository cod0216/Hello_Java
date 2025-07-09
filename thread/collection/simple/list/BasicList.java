package thread.collection.simple.list;

import util.ThreadUtils;

import java.util.Arrays;

public class BasicList implements SimpleList{

    public static final int DEFALUT_CAPACITY = 5;

    private Object[] elements;
    private int size = 0;

    public BasicList() {
        this.elements = new Object[DEFALUT_CAPACITY];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object e) {
        elements[size] = e;
        ThreadUtils.sleep(100);//멀티스레드 문제를 쉽게 확인하는 코드
        size++;
    }

    public Object get(int index){
        return elements[index];
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(elements, size)) + " size = " + size + ", capacity = " + elements.length;
    }
}
