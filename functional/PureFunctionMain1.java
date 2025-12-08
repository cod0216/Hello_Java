package functional;

import java.util.function.Function;
/*
    순수 함수 (Pure Function)
    같은 인자를 주면 항상 같은 결과를 반환하는 함수이다.
    외부 상태(변할 수 있는 전역 변수 등)에 의존하거나, 외부 상태를 변경하는 부수 효과(Side Effect)가 없는 함수를 의미
 */


public class PureFunctionMain1 {
    public static void main(String[] args) {
        Function<Integer, Integer> fuc = x -> x * 2;
        System.out.println(fuc.apply(10));
        System.out.println(fuc.apply(10));
        System.out.println(fuc.apply(10));
        System.out.println(fuc.apply(10));
        System.out.println(fuc.apply(10));
    }
}
