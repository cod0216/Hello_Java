import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] sArray = str.toCharArray();
        for(int i = 0; i < str.length(); i++){
            System.out.println(sArray[i]);
        }
        
    }
}