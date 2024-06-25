package collection.map;


import java.util.*;

public class MapMain1 {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();

        studentMap.put("studentA", 90);
        studentMap.put("studentB", 80);
        studentMap.put("studentC", 70);
        studentMap.put("studentD", 60);
        System.out.println("studentMap = " + studentMap);

        Integer result = studentMap.get("studentD");
        System.out.println("result = " + result);

        System.out.println("KeySet 활용");
        Set<String> key = studentMap.keySet();
        for (String s : key) {
            Integer score = studentMap.get(s);
            System.out.println("key = " + s + ", value = " + score);
        }

        System.out.println("EntrySet 활용");
        Set<Map.Entry<String, Integer>> entries = studentMap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String student = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("student = " + student + ", value = " + value);
        }


        System.out.println("Values 활용");
        Collection<Integer> values = studentMap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }
    }
}
