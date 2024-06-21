package collection.set;

import generic.animal.Cat;

import java.util.*;

public class HashStart5 {
    static final int CAPACITY = 10;
    public static void main(String[] args) {
        LinkedList<Integer>[] buckets = new LinkedList[CAPACITY];
        for(int i = 0; i < CAPACITY; i++){
            buckets[i] = new LinkedList<>();
        }
        System.out.println("buckets = " + Arrays.toString(buckets));

        add(buckets, 1);
        add(buckets, 2);
        add(buckets, 5);
        add(buckets, 8);
        add(buckets, 14);
        add(buckets, 99);
        add(buckets, 9);

        System.out.println("buckets = " + Arrays.toString(buckets));

        int searchValue = 9;
        System.out.println("contains(" + searchValue + ") : " + contains(buckets, searchValue));


    }
    static int hashIndex(int value){
        return value % 10;
    }
    static void add(LinkedList<Integer>[] A, int value){
        int hashValue = hashIndex(value);
        LinkedList<Integer> bucket = A[hashValue];
        if(!bucket.contains(value)) {
            bucket.add(value);
        }
    }

    static boolean contains(LinkedList<Integer>[] A, int searchValue){
        int hashValue = hashIndex(searchValue);
        LinkedList<Integer> bucket = A[hashValue];
        return bucket.contains(searchValue);

    }
}
