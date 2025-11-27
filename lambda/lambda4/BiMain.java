package lambda.lambda4;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiMain {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a+b;
        System.out.println("add.apply(1,2) = " + add.apply(1, 2));

        BiConsumer<String, Integer> repeat = (s, a) -> {
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.print(s);
            for (int i = 0; i < a; i++) {
                System.out.print("*");
            }
            System.out.println();
        };
        repeat.accept("hello", 10);

        BiPredicate<Integer, Integer> isGreater = (a, b) -> a > b;

        System.out.println("isGreater.test(10,2) = " + isGreater.test(10, 2));
    }
}
