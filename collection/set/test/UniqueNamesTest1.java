package collection.set.test;

import java.util.*;

public class UniqueNamesTest1 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};

        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < inputArr.length; i++){
            int num = inputArr[i];
            hashSet.add(num);
        }

        for (Integer integer : hashSet) {
            System.out.println(integer);
        }
    }
}
