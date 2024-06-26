package collection.map.test;

import java.util.*;

public class ItemPriceTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("사과", 500);
        map.put("바나나", 500);
        map.put("망고", 1000);
        map.put("딸기", 1000);
        ArrayList<String> arr = new ArrayList<>();
        for (Map.Entry<String, Integer> str : map.entrySet()) {
            if(str.getValue() == 1000)
                arr.add(str.getKey());
        }
        System.out.println(arr);



    }
}
