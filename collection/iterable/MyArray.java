package collection.iterable;

import java.util.Iterator;

public class MyArray implements Iterable<Integer> {
    private int[] number;

    public MyArray(int[] number) {
        this.number = number;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new MyArrayIterator(number);
    }
}
