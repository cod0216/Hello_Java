package collection.set.test;

import java.util.*;

public class SetOperationsTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        Set<Integer> set2 = new HashSet<>(List.of(3, 4, 5, 6, 7));

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        for (Integer integer : set1) {
            linkedHashSet.add(integer);
        }
        for (Integer integer : set2) {
            linkedHashSet.add(integer);
        }
        System.out.println("합집합 " + linkedHashSet);

        linkedHashSet = new LinkedHashSet<>();
        for (Integer integer : set2) {
            if(set1.contains(integer))
                linkedHashSet.add(integer);
        }
        System.out.println("교집합 " + linkedHashSet);

        linkedHashSet = new LinkedHashSet<>();
        for (Integer integer : set2) {
            if(!set1.contains(integer))
                linkedHashSet.add(integer);
        }
        System.out.println("차집합 " + linkedHashSet);

    }
}
