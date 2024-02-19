package TIL;

import java.util.Scanner;

public class J1193 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalNumber = 0;
        int cnt = 0;
        int num = scanner.nextInt();




        while(true) {
            totalNumber += cnt;
            if (num <= totalNumber) {

                if(cnt%2 ==0) {
                    System.out.println(num - (totalNumber - cnt) + "/" + ( totalNumber - num +1));
                }
                else {
                    System.out.println( (totalNumber - num +1) + "/" + (num - (totalNumber - cnt)));
                }
                return;
            }
            cnt++;
        }
    }
}
