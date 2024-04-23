package enumeration.ref3;


import static enumeration.ref3.Grade.*;

public class EnumRefMain2 {
    public static void main(String[] args) {

        int price = 10000;
//        DiscountService discountService = new DiscountService();
        printDiscount(BASIC,price);
        printDiscount(GOLD,price);
        printDiscount(DIAMOND,price);
    }

    private static void printDiscount(Grade grade, int price){
        System.out.println(grade.name() + "등급의 할인 금액 : " +grade.discount(price));
    }
}
