package lambda.ex3;

import lambda.ex2.StringFunction;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class MapExample {
    // 고차 함수, 함수를 인자로 받아, 리스트의 각 요소를 반환
    public static List<String> map(List<String> list, UnaryOperator<String> func){
        List<String> str = new LinkedList<>();

        for (String s : list) {
            str.add(func.apply(s));
        }
        return str;

    }

    public static void main(String[] args){
        List<String> words = List.of("hello", "java", "lambda");
        System.out.println("원본 리스트 : " + words);

        UnaryOperator<String> func1 = (s) -> s.toUpperCase();
        UnaryOperator<String> func2 = (s) -> "***"+s+"***";
        List<String> map = map(words, func1);
        System.out.println(map.toString());

        map = map(words, func2);
        System.out.println(map.toString());

    }
}
