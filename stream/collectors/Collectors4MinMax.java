package stream.collectors;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Collectors4MinMax {
    public static void main(String[] args) {
        // 다운스트림 컬랙터에서 유용하게 사용
        Integer max1 = Stream.of(1,2,3)
                .collect(Collectors.maxBy(
                        ((t1, t2) -> t1.compareTo(t2)))).get();
        System.out.println("max1 = " + max1);

        Integer max2 = Stream.of(1,2,3)
                        .max((t1,t2) -> t1.compareTo(t2)).get();
        System.out.println("max2 = " + max2);

        Integer max3 = Stream.of(1,2,3)
                .max(Integer::compareTo).get();
        System.out.println("max3 = " + max3);

        int max4 = IntStream.of(1,2,3)
                .max().getAsInt();
        System.out.println("max4 = " + max4);
    }
}
