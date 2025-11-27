package lambda.lambda4;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class OperatorMain {
    public static void main(String[] args) {
        // UnaryOperator
        Function<Integer, Integer> square1 = i -> i*i;
        UnaryOperator<Integer> square2 = i -> i*i;

        System.out.println("square1.apply(10) = " + square1.apply(10));
        System.out.println("square2.apply(10) = " + square2.apply(10));

        // BinaryOperator
        BiFunction<Integer, Integer,Integer> addition1 = (i, j) -> i+j;
        BinaryOperator<Integer> addition2 = (i,j) -> i+j;

        System.out.println("addition1.apply(1,3) = " + addition1.apply(1, 3));
        System.out.println("addition2.apply(1,3) = " + addition2.apply(1, 3));
    }
}
