package lambda.ex2;

import java.util.ArrayList;
import java.util.List;

public class FilterExample2 {
    public static List<Integer> filter(List<Integer> list, MyPredicate predicate){
        List<Integer> result = new ArrayList<>();
        for (int val : list) {
            if(predicate.test(val)) {
                result.add(val);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3,-2,-1, 2, 3, 5);
        System.out.println("원본 리스트 : " + numbers);

        MyPredicate negative = (value) -> {
                if (value < 0) return true;
                return false;
        };

        MyPredicate even = (value) -> {
                if(value % 2 == 0) return true;
                return false;
        };

        // 1, 음수(negative)만 뽑아내기
        System.out.println(filter(numbers, negative).toString());

        // 2. 짝수(even)만 뽑아내기
        System.out.println(filter(numbers, even).toString());

    }
}
