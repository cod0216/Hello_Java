package lambda.lambda3;

import java.util.function.Function;

public class TargetType2 {
    public static void main(String[] args) {
        Function<String, String> functionA = s -> s.toUpperCase();
        Function<Integer, String> functionB = i -> "value" + i;
        System.out.println("functionA = " + functionA.apply("hello"));
        System.out.println("functionB = " + functionB.apply(10));
    }

}
