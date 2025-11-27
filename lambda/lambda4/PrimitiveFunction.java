package lambda.lambda4;

import java.util.function.IntFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ToIntFunction;

public class PrimitiveFunction {
    public static void main(String[] args) {
        // 기본형 매개변수, IntFunction, LongFunction, DoubleFunction
        IntFunction<String> function = i -> "숫자 : " + i;
        System.out.println("function.apply(10) = " + function.apply(10));

        // 기본형 반환, ToIntFunction, ToLongFunction, ToDoubleFuntion
        ToIntFunction<String> toIntFunction = s -> Integer.parseInt(s);
        System.out.println("toIntFunction.applyAsInt(10) = " + toIntFunction.applyAsInt("10"));

        // 기본형 매개변수, 기본형 반환
        IntToLongFunction intToLongFunction = x-> (long)x*100;
        System.out.println("intToLongFunction.applyAsLong(10) = " + intToLongFunction.applyAsLong(10));

        // IntUnaryOperator : int -> int
        IntUnaryOperator intUnaryOperator = x -> x*10;
        System.out.println("intUnaryOperator.applyAsInt(10) = " + intUnaryOperator.applyAsInt(10));

        // IntConsumer, IntSupplier, IntPredicate 등
    }
}
