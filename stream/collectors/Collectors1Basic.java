package stream.collectors;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors1Basic {
    public static void main(String[] args) {

        // 기본 기능
        List<String> list = Stream.of("Java", "Spring", "JPA")
                .collect(Collectors.toList());
        System.out.println("list = " + list);

        // 수정 불가능 리스트
        List<Integer> unmodifiableList = Stream.of(1,2,3)
                .collect(Collectors.toUnmodifiableList());
//        unmodifiableList.add(4); // 런타임 예외 발생
        System.out.println("unmodifiableList = " + unmodifiableList);

        Set<Integer> set = Stream.of(1,2,2,3,3,3)
                .collect(Collectors.toSet());
        System.out.println("set = " + set);


        // 타입 지정
        Set<Integer> treeSet = Stream.of(3,4,5,2,1)
                .collect(Collectors.toCollection(TreeSet::new)); // Tree Set - 정렬 상태 유지
        System.out.println("treeSet = " + treeSet);


    }
}
