package scanner.ex;

import java.util.Scanner;

public class ScannerEx3 {
    public static void main(String[] args) {
        Scanner intput = new Scanner(System.in);

        System.out.print("음식 이름을 입력해주세요 : ");
        String foodName = intput.nextLine();

        System.out.print("음식의 가격을 입력해주세요 : ");
        int foodprice = intput.nextInt();

        System.out.print("음식의 수량을 입력하세요 : ");
        int foodQuantiy = intput.nextInt();

        int totalPrice = foodprice * foodQuantiy;

        System.out.println(foodName + " "  + foodprice + "원 을 " + foodQuantiy + "개 주문하여 총 " + totalPrice + "원을 내야 됩니다.");


    }
}
