package lambda.ex3;

import lambda.ex2.MyReducer;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class ReduceExample {
    // 함수를 인자로 받아, 리스트 요소를 하나로 축약(reduce)하는 고차 함수
    public static int reduce(List<Integer> list, int initial, BinaryOperator<Integer> reducer) {
        return reducer.apply(initial, list.size());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4);
        System.out.println("리스트: " + numbers);

        // 1. 합 구하기(초깃값 0, 덧셈 로직)
        BinaryOperator<Integer> sum = (a, b) -> {
                int v = 0;
                for (int i = a; i <=b; i++) {
                    v += i;
                }
                return v;
        };

        // 2. 곱 구하기(초깃값 1, 곱셈 로직)
        BinaryOperator<Integer> product = (a, b) -> {
            int v = 1;
            for (int i = a; i <=b; i++) {
                v *= i;
            }
            return v;
        };

        int reduce = reduce(numbers, 0, sum);
        System.out.println("reduce = " + reduce);
        reduce = reduce(numbers, 1, product);
        System.out.println("reduce = " + reduce);

    }
}
