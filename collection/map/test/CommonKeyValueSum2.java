package collection.map.test;

import java.util.HashMap;
import java.util.Map;

public class CommonKeyValueSum2 {
    public static void main(String[] args) {
        Map<String, Integer> map1 = Map.of("A", 1, "B", 2, "C", 3);
        Map<String, Integer> map2 = Map.of("B", 4, "C", 5, "D", 6);
        Map<String, Integer> map3 = new HashMap<>();

        for (String key : map1.keySet()) {
            int sum = 0;
            if(map2.containsKey(key)){
                sum += map2.get(key);
                sum += map1.get(key);
                map3.put(key, sum);
            }
        }
        System.out.println(map3);
    }
}
