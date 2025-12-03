package stream.operation;

import java.util.IntSummaryStatistics;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreamMain {
    public static void main(String[] args) {
        // 기본형 특화 스트림 생성(IntStream, LongStream, DoubleStream)
        IntStream stream = IntStream.of(1,2,3,4,5);
        stream.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream range1 = IntStream.range(1, 6); // 1,2,3,4,5
        range1.forEach(i -> System.out.print(i + " "));
        System.out.println();

        IntStream range2 = IntStream.rangeClosed(1, 6); // 1,2,3,4,6
        range2.forEach(i -> System.out.print(i + " "));
        System.out.println();

        // 통계 관련 메서드(sum, average, min, max, count)
        int sum = IntStream.range(1,6).sum();
        System.out.println("sum = " + sum);

        // average() : 평균값 계산
        double avg = IntStream.range(1, 6).average().getAsDouble();
        System.out.println("avg = " + avg);

        System.out.println();

        IntSummaryStatistics state = IntStream.range(1, 6).summaryStatistics();
        System.out.println("합계 : " + state.getSum());
        System.out.println("평균 : " + state.getAverage());
        System.out.println("최댓값 : " + state.getMax());
        System.out.println("최솟값 : " + state.getMin());
        System.out.println("개수 : " + state.getCount());

        // 2. 타입 변환 메서드
        // IntStream -> LongStream
        LongStream longStream = IntStream.range(1, 6).asLongStream();
        // IntStream -> DoubleStream
        DoubleStream doubleStream = IntStream.range(1, 6).asDoubleStream();

        // IntStream -> Stream<Integer>
        Stream<Integer> boxed = IntStream.range(1, 6).boxed();

        // 3.기본형 특화 매핑
        // int -> long 변환 맵핑
        LongStream mappedLong = IntStream.range(1, 5)
                .mapToLong(i -> i*10L);
        // int -> double 변환 맵핑
        DoubleStream mappedDouble = IntStream.range(1, 5)
                .mapToDouble(i -> i * 10L);
        // int -> object 변환 맵핑
        Stream<String> mappedObject = IntStream.range(1,5)
                .mapToObj(i -> "number : " + i);

        // 4. 객체 스트림 -> 기본형 특화 스트림으로 매핑
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
        IntStream intStream = integerStream.mapToInt(i -> i);

        // 5. 객체 스트림 ->  기본형 특화 스트림으로 매핑 활용
        int result = Stream.of(1,2,3,4,5)
                .mapToInt(i -> i)
                .sum();



    }
}
