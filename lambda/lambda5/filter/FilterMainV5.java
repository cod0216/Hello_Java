package lambda.lambda5.filter;

import java.util.List;

import static lambda.lambda5.filter.GenericFilter.filter;

public class FilterMainV5 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9,10);

        // 짝수만 거르기
        List<Integer> evenNumbers = filter(numbers, i -> i % 2 ==0 );
        System.out.println("evenNumbers = " + evenNumbers);

        // 홀수만 거르기
        List<Integer> oddNumber = filter(numbers, i -> i % 2 == 1);
        System.out.println("oddNumber = " + oddNumber);

        // 문자 사용 필터
        List<String> strings = List.of("A", "BB", "CCC");
        List<String> stringResult = filter(strings, s -> s.length()>=2);
        System.out.println("stringResult = " + stringResult);

    }
}
