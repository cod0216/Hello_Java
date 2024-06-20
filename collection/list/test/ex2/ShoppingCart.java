package collection.list.test.ex2;

import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);

    }
    public void displayItem(){
        System.out.println("장바구니 상품 출력");
        int sum = 0;
        for(Item a : items){

            System.out.println("상품명 : " + a.getName() + ", 합계 : " + a.getTotalPrice(););
            sum += a.getTotalPrice();;
        }

        System.out.println("전체 가격 합 : " + sum);

    }

}
