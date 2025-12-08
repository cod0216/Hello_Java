package functional;

import java.util.function.Function;

/*
    함수 합성(Composition)
    간단한 함수를 조합해 더 복잡한 함수를 만드는 것을 권장한다.
    작은 단위의 함수들을 체이닝(Chaining)하거나 파이프라이닝(Pipelining)해서 재사용성을 높이고, 코드 이해도를 높인다.
 */
public class CompositionMain2 {
    public static void main(String[] args) {
        // 1. String -> Integer
        Function<String, Integer> paresInt = Integer::parseInt;

        // 2. Integer -> Integer
        Function<Integer, Integer> square = x -> x * x;

        // 3. Integer -> String
        Function<Integer, String> toString = x -> "결과 : " + x;

        // compose 혹은 andThen으로 합성하기
        // parseInt -> square -> toString 순서로 하고 싶다면 andThen()을 사용
        Function<String, String> finalFunc = paresInt
                .andThen(square)
                .andThen(toString);

        // 문자열 "5"를 입력하면 파싱 -> 제곱 -> 문자열 출력 순서
        String result1 = finalFunc.apply("5");
        System.out.println("result1 = " + result1);

        String result2 = finalFunc.apply("10");
        System.out.println("result2 = " + result2); // 결과 : 100

        // 또 다른 조합으로 사용 가능
        Function<String, Integer> stringToSquareFunc = paresInt
                .andThen(square);
        Integer result3 = stringToSquareFunc.apply("5");
        System.out.println("result3 = " + result3);
    }
}
