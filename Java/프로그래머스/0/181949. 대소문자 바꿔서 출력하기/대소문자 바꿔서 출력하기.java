import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] str = a.toCharArray();
        for(int i = 0 ; i < a.length(); i++){
            if(97 > (int)str[i]) System.out.print(Character.toLowerCase(str[i]));
            else System.out.print(Character.toUpperCase(str[i]));
        }
    }
}