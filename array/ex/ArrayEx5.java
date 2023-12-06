package array.ex;

import java.util.Scanner;

public class ArrayEx5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 받을 숫자의 개수를 입력하세요 : ");

        int count = scanner.nextInt();
        int[] numbers = new int[count];
        int sum = 0;
        double average = 0.0;

        System.out.print("저장할 숫자를 입력하세요 : ");

        for(int i = 0; i < count; i ++)
            numbers[i] = scanner.nextInt();
        System.out.println("입력한 숫자는 다음과 같습니다. ");
        for(int i = 0; i < count; i++) {
            System.out.print(numbers[i]);
            if( i != count-1)
                System.out.print(", ");
        }



    }
}
