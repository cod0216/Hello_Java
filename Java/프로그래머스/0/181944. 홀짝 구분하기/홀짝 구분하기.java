import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(n + " ");
        if(n % 2 == 1) System.out.println("is odd");
        else System.out.println("is even");
    }
}