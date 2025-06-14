package collection.set.test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class UniqueNamesTest2 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();

        for(int i = 0; i < inputArr.length; i++){
            int num = inputArr[i];
            linkedHashSet.add(num);
        }

        for (Integer integer : linkedHashSet) {
            System.out.println(integer);
        }
    }
}
