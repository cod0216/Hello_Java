package collection.map;

import java.util.HashMap;
import java.util.Map;

public class MapMain3 {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        studentMap.put("StudentA", 50);
        System.out.println(studentMap);

        if(!studentMap.containsKey("StudentA")){
            studentMap.put("StudentA", 100);
        }
        System.out.println(studentMap);

        studentMap.putIfAbsent("StudentA", 100);
        studentMap.putIfAbsent("StudentB", 100);
        System.out.println(studentMap);

    }
}
