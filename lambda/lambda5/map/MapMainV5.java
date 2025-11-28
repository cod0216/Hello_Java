package lambda.lambda5.map;

import java.util.List;

import static lambda.lambda5.map.GenericMapper.map;

public class MapMainV5 {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana","mango");

        // 문자 -> 문자
        List<String> uppderFruits = map(list, s -> s.toUpperCase());
        System.out.println("uppderFruits = " + uppderFruits);

        // 문자열을 숫자로 변환
        List<Integer> numbers = map(list, s -> s.length());
        System.out.println("numbers = " + numbers);

        // 숫자 -> 문자
        List<Integer> integer = List.of(1,2,3);
        List<String> repeat = map(integer, n -> "*".repeat(n));
        System.out.println("repeat = " + repeat);



    }

}
