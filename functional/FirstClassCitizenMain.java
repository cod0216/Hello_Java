package functional;

import java.util.function.Function;

/*
    일급시민(First Class Citizien)
    함수가 일반 값(숫자, 문자열, 객체(자료구조) 등)과 동일한 지위를 가진다.
    함수를 변수에 대입하거나, 다른 함수의 인자로 전달하거나, 함쉐서 함수를 반환하는 고차 함수(Higher-order Function)를 자유롭게 사용할 수 있다.
 */
public class FirstClassCitizenMain {
    public static void main(String[] args) {
        // 함수를 변수에 담는다
        Function<Integer, Integer> func = x -> x*2;

        // 함수를 인자로 전달
        applyFunction(10, func);

        // 함수를 반환
        getFunc().apply(10);
    }

    // 고차 함수 : 함수를 인자로 받음
    private static Integer applyFunction(Integer input, Function<Integer, Integer> func) {
        return func.apply(input);
    }

    // 고차 함수 : 함수를 반환
    private static Function<Integer, Integer> getFunc() {
        return x -> x*2;
    }
}
