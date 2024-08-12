package TIL;

import java.util.*;
import java.io.*;

public class S1952 {
    static int min;
    static int[] monthArr;
    static int[] price;


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(buffer.readLine());
        int k = 0;
        while(K >k) {
            String[] input = buffer.readLine().split(" ");
            price = new int[4];
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(input[i]);
            }

            monthArr = new int[13];

            input = buffer.readLine().split(" ");
            for (int i = 0; i < 12; i++) {
                monthArr[i+1] = Integer.parseInt(input[i]);
            }
            min = price[3];
            int sum = 0;

            DFS(1, sum);

            k++;
            System.out.println("#" + k + " " + min);
        }
    }

    static public void DFS(int month, int sum){
        if(min < sum){
            return;
        }
        if(month >12){
            min = Math.min(min,sum);
            return;
        }

        if(monthArr[month] == 0 ){
            DFS(month + 1, sum);
        } else{
            DFS(month +1, price[0]*monthArr[month]+sum);
            DFS(month +1, price[1]+sum);
            DFS(month +3, price[2]+sum);
        }
    }
}
