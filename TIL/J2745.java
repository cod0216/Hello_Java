package TIL;

import java.util.Scanner;

public class J2745 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] arr = new int[str.length()];
        for(int i = 0; i < arr.length; i++){
            if((str.charAt(i) >= '0') && (str.charAt(i) <='9'))
                arr[i] = str.charAt(i)-'0';
            else {
                arr[i] = str.charAt(i) - 'A' + 10;
            }
        }
        int num = scanner.nextInt();
        if (num <2)
            return;
        int numNum = 0;
        int result = 0;
        if(arr.length == 1) {
            System.out.println(arr[0]);
            return;
        }
        if(arr.length == 2) {
            System.out.println(arr[0] + arr[1]*num);
            return;

        }
        if(arr.length >=3) {
            for (int i = 0; i < arr.length - 2; i++) {
                numNum = math(num, i + 1);
                result += arr[arr.length - i - 3] * numNum;
            }

            System.out.println(result + arr[arr.length - 1] + arr[arr.length - 2] * num);
        }
    }
    static public int math(int num, int n) {
        int value = num;
        for(int i = 0; i < n; i++){
            num *= value;
        }
        return num;
    }
}
