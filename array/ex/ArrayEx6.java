package array.ex;

import java.util.Scanner;

public class ArrayEx6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력 받을 숫자의 개수를 입력하세요: ");
        int n = scanner.nextInt();

        int [] numbers = new int[n];
        int minNumber, maxNumber;

        System.out.println(n + "개의 정수를 입력하세요");
        for(int i = 0; i < n; i++)
            numbers[i] = scanner.nextInt();
        minNumber = maxNumber = numbers[0];

        for (int i =1; i < n; i ++) {
            if (maxNumber < numbers[i])
                maxNumber = numbers[i];
            if (minNumber > numbers[i])
                minNumber = numbers[i];
        }
        System.out.println("가장 작은 수는 : " + minNumber + " 입니다.");
        System.out.println("가장 큰 수는 : " + maxNumber + " 입니다.");
    }
}
