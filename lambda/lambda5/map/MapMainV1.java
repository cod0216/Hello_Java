package lambda.lambda5.map;

import java.util.ArrayList;
import java.util.List;

public class MapMainV1 {
    public static void main(String[] args) {
        List<String> list = List.of("1", "12","123","1234");

        // 문자열을 숫자로 변환
        List<Integer> numbers = mapStringToIntger(list);
        System.out.println("numbers = " + numbers);

    }

    private static List<Integer> mapStringToIntger(List<String> list) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : list) {
            Integer value = Integer.valueOf(s);
            numbers.add(value);
        }
        return numbers;
    }
}
