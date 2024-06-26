package collection.map.test;

import java.util.*;

public class ArrayToMapTest {
    public static void main(String[] args) {
        String[][] productArr = {{"Java", "10000"}, {"Spring", "20000"}, {"JPA", "30000"}};
        Map<String, Integer> map = new HashMap<>();

        for (String[] arr : productArr) {
            map.put(arr[0],Integer.valueOf(arr[1]));
        }

        for (Map.Entry<String, Integer> arr : map.entrySet()) {
            System.out.println("제품 : " + arr.getKey() + ", 가격 : " + arr.getValue());
        }


    }
}
