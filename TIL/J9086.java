package TIL;

import java.util.Scanner;

public class J9086 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
/*
        String str = scanner.nextLine();
        char[] var = str.toCharArray();

        System.out.println("var[1] :" + var[1]);
*/

        int n = scanner.nextInt();
        String[] str = new String[n];
        scanner.nextLine();

        for(int i = 0; i < n; i++){
            str[i] = scanner.nextLine();

        }
        for (int i = 0; i < n; i++) {
            char[] var = str[i].toCharArray();
            int num = str[i].length()-1;
            System.out.print(var[0]);
            System.out.println(var[num]);
        }


    }
}
