package stream.basic;

import java.util.List;
import java.util.stream.Stream;

public class DuplicateExcutionMain {
    public static void main(String[] args) {
        // 스트림 중복 실행 확인
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println); // 1. 최초 실행
//        integerStream.forEach(System.out::println); // 2. 중복 실행

        List list = List.of(1,2,3,4,5);
        Stream.of(list).forEach(System.out::println);
        Stream.of(list).forEach(System.out::println);

    }
}
