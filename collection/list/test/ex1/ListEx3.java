package collection.list.test.ex1;

import java.util.LinkedList;
import java.util.Scanner;

public class ListEx3 {
    public static void main(String[] args) {
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        int sum = 0;
        while(num != 0){
            list.add(num);
            num = scanner.nextInt();
        }
        for(int i : list){
            sum += i;
        }

        System.out.println("입력한 정수의 합계 : " + sum);
        System.out.println("입력한 정수의 평균 : " + (double)sum/list.size());
    }
}
