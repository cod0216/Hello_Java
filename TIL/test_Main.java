package TIL;

import java.util.Scanner;

public class test_Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        int var = scanner.nextInt();
        scanner.nextLine();
        String str2 = scanner.nextLine();


//        char[] lit = str2.toCharArray();

        System.out.println("str1 :" + str1 + ", var :" + var + ", str2 :" + str2);
    }
}
