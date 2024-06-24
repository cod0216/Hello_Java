package collection.set.test;

import java.util.TreeSet;

public class UniqueNamesTest3 {
    public static void main(String[] args) {
        Integer[] inputArr = {30, 20, 20, 10, 10};
        TreeSet<Integer> treeSet = new TreeSet<>();

        for(int i = 0; i < inputArr.length; i++){
            int num = inputArr[i];
            treeSet.add(num);
        }

        for (Integer integer : treeSet) {
            System.out.println(integer);
        }
    }
}
