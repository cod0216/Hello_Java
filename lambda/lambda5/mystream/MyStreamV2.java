package lambda.lambda5.mystream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

// static factory 추가
public class MyStreamV2 {
    List<Integer> integerList;

    private MyStreamV2(List<Integer> integerList) {
        this.integerList = integerList;
    }

    // static factory
    public static MyStreamV2 of(List<Integer> integerList) {
        return new MyStreamV2(integerList);
    }
    public MyStreamV2 filter (Predicate<Integer> predicate){
        List<Integer> filtered = new ArrayList<>();
        for (Integer element : integerList) {
            if(predicate.test(element)) filtered.add(element);
        }
        return new MyStreamV2(filtered);
    }

    public MyStreamV2 map (Function<Integer, Integer> mapper) {
        List<Integer> mapped = new ArrayList<>();
        for (Integer integer : integerList) {
            mapped.add(mapper.apply(integer));
        }
        return new MyStreamV2(mapped);
    }

    public List<Integer> toList(){
        return integerList;
    }

}
