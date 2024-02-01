package TIL;

import java.util.Scanner;

public class J2903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = squareResult(num);
        System.out.println(resultValue(result));
    }

    public static int squareResult(int n){
        int value = 1;

        for (int i = 0; i < n; i++)
        {
            value *=2;
        }
        return value;
    }
    public static int resultValue(int n){
        int value = n+1;
        return value*value;
    }
}
