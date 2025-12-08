package functional;

import java.util.function.Function;

/*
    부수 효과(Side Effect) 최소화
    함수형 프로그래밍에서는 상태 변화를 최소화하기 위해 변수나 객체를 변경하는 것을 지양한다.
    이로 인해 프로그램의 버그가 줄어들고, 테스트나 병렬 처리(Parallelism), 동시성(Concurency) 지원이 용이해진다.
 */

public class SideEffectMain2 {

    public static void main(String[] args) {
        Function<Integer, Integer> func = x -> {
            int result = x*2;
            System.out.println("X = " + x + ", result = " + (x*2)); // 콘솔 창 또한 외부 자원 이므로 Size Effect
            return result;
        };

        func.apply(10);
        func.apply(10);
        func.apply(10);
    }
}
