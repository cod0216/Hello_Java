package collection.list;

public interface MyList<E> {
    int size();

    void add(E e);

    E get(int index);

    E set(int index, E element);

    E remove(int index);



}
