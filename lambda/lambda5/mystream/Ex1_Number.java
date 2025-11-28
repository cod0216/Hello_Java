package lambda.lambda5.mystream;

import lambda.lambda5.filter.GenericFilter;
import lambda.lambda5.map.GenericMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static lambda.lambda5.filter.GenericFilter.filter;

public class Ex1_Number {
    public static void main(String[] args) {
        // 짝수만남기고, 남은 값의 2배를 반환,
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> directResult = direct(numbers);
        System.out.println("directResult = " + directResult);

        List<Integer> lambdaResult = lambda(numbers);
        System.out.println("lambdaResult = " + lambdaResult);

    }

    private static List<Integer> lambda(List<Integer> numbers) {
        return GenericMapper.map(filter(numbers, i -> i % 2 == 0), s -> s * 2);
    }


    private static List<Integer> direct(List<Integer> numbers) {
        List<Integer> ans = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 == 0) ans.add(number*2);
        }
        return ans;
    }
}
