package TIL;

import java.util.Scanner;

public class J2292 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int six = 6;
        int resultNum = 1;

        for(int i = 0; i <num; i++){
            resultNum = resultNum + six * i;
            if(num == 1) {
                System.out.println(1);
                break;
            }
            if(resultNum >= num) {
                System.out.println(i+1);
                break;
            }
        }

    }
}


