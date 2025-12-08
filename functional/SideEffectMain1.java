package functional;

import java.util.function.Function;

/*
    부수 효과(Side Effect) 최소화
    함수형 프로그래밍에서는 상태 변화를 최소화하기 위해 변수나 객체를 변경하는 것을 지양한다.
    이로 인해 프로그램의 버그가 줄어들고, 테스트나 병렬 처리(Parallelism), 동시성(Concurency) 지원이 용이해진다.
 */

public class SideEffectMain1 {
    public static int count = 0;

    public static void main(String[] args) {
        System.out.println("before count = " + count);
        Function<Integer, Integer> func = x -> {
            count++; // 외부 값이 바뀐다. --> Side Effect
            return x*2;
        };

        func.apply(10);

        System.out.println("after count = " + count);
    }
}
