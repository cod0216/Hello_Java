package functional;

import java.util.function.Function;

/*
    부수 효과(Side Effect) 최소화
    함수형 프로그래밍에서는 상태 변화를 최소화하기 위해 변수나 객체를 변경하는 것을 지양한다.
    이로 인해 프로그램의 버그가 줄어들고, 테스트나 병렬 처리(Parallelism), 동시성(Concurency) 지원이 용이해진다.
 */

public class SideEffectMain3 {

    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> x*2;
        int x = 10;
        int result = func.apply(x);

        // 부수 효과는 순수 함수와 분리해서 실행
        // 출력은 별도로 처리해 순수성을 유지
        System.out.println("X = " + x + ", result = " + result);
    }
}
