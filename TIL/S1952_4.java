package TIL;

import java.util.*;
import java.io.*;

public class S1952_4 {
    static int min;
    static int[] monthArr;
    static int[] price;
    static int[] dp;


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

            monthArr = new int[12];
            dp = new int[12];

            input = buffer.readLine().split(" ");
            for (int i = 0; i < 12; i++) {
                monthArr[i] = Integer.parseInt(input[i]);
            }

            Arrays.fill(dp,-1);

            dp[0] = Math.min(Math.min(monthArr[0] * price[0], price[1]), price[2]);

            int res = Math.min(DFS(11), price[3]);

            k++;
            System.out.println("#" + k + " " + res);
        }
    }

    static public int DFS(int month){
        if(dp[month] == -1){
            dp[month] = Math.min(price[1], (price[0]*monthArr[month])) + DFS(month-1);
        }

        if(month -3 >=0) {
            dp[month] = Math.min(dp[month], DFS(month-3)+price[2]);
        }else{
            dp[month] = Math.min(price[2],dp[month]);
        }
        return dp[month];
    }
}
