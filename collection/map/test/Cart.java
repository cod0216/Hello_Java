package collection.map.test;

import java.util.*;

public class Cart {
    private Map<Product, Integer> cartMap = new HashMap<>();

    public void add(Product product, int cnt){
        int num = cartMap.getOrDefault(product, 0);
        cartMap.put(product, num+cnt);
    }
    public void minus(Product product, int cnt){
        int num = cartMap.get(product) - cnt;
        if(num <= 0) cartMap.remove(product);
        else cartMap.put(product, num);
    }
    public void printAll(){
        System.out.println("==모든 상품 출력==");
        for (Map.Entry<Product, Integer> cartEntry : cartMap.entrySet()) {
            System.out.println("상품 : " + cartEntry.getKey() + " 수량 : " + cartEntry.getValue());
        }
    }
}
