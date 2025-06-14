package collection.map.test;

import java.util.*;
public class WordFrequencyTest1 {
    public static void main(String[] args) {
        String text = "orange banana apple apple banana apple";

        String[] str = text.split(" ");
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length; i++){
            if(map.containsKey(str[i])){
                int num = map.get(str[i]);
                num++;
                map.put(str[i], num);
            } else map.put(str[i], 1);
        }
        System.out.println(map);
    }
}
