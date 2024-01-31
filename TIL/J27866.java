package TIL;

import java.util.Scanner;

public class J27866 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        char a[] = str.toCharArray();

        int n = scanner.nextInt();

        System.out.println(a[n-1]);

    }

}