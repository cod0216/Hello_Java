package lambda.lambda4;

import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {

        // 익명 클래스
        Function<String, Integer> function1 = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        Integer result1 = function1.apply("hello");
        System.out.println("result1 = " + result1);

        Function<String, Integer> function2 = s -> s.length();
        Integer result2 = function2.apply("hello");
        System.out.println("result2 = " + result2);
    }
}
