package TIL;

import java.util.Scanner;

public class J2018_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int[] numArray = new int[num+1];
        int cnt = 0;
        int sum = 0;
        int startPoint = 0;
        int endPoint = 1;

        for(int i = 0; i <= num; i++){
            sum += i;
            numArray[i] = sum;
        }

        while(endPoint != num+1){
            if((numArray[endPoint] - numArray[startPoint]) < num)
                endPoint++;
            else if ((numArray[endPoint] - numArray[startPoint]) > num) {
                startPoint++;
            }
            else if((numArray[endPoint] - numArray[startPoint]) == num){
                cnt++;
                endPoint++;
            }
        }

        System.out.println(cnt);
    }
}
