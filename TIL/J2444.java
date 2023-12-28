package TIL;

import java.util.Scanner;

public class J2444 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0; i < n; i ++){
            for(int j = n-1-i; j >0; j-- )
                System.out.print(" ");
            for(int j = 0; j < (1+i) ; j++)
                System.out.print("*");
            for(int j = 0; j < i ; j++)
                System.out.print("*");
            System.out.println();
        }
        for(int i = n-1; i > 0; i --){
            for(int j = 0; j < n-i; j++ )
                System.out.print(" ");
            for(int j = i; j > 0 ; j--)
                System.out.print("*");
            for(int j = i-1; j > 0 ; j--)
                System.out.print("*");
            System.out.println();
        }
    }
}
