package TIL;

import java.util.*;
import java.io.*;

public class J1010 {
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
             String[] input = buffer.readLine().split(" ");
             int N  = Integer.parseInt(input[0]);
             int M = Integer.parseInt(input[1]);

             dp = new int[M+1][M+1];


             for(int i = 0; i<= M; i++) {
                 dp[i][1] = i;
                 dp[i][0] = 1;
                 dp[i][i] = 1;
             }

             for(int i = 1 ; i <= M; i++){
                 for(int j = 1 ; j <= M; j++){
                     dp[i][j] = dp[i-1][j]+dp[i-1][j-1];
                 }
             }

             t++;
            System.out.println(dp[M][N]);
        }
    }

    public static int combo(int M, int N){
        if (dp[M][N] != -1) return dp[M][N];
        return dp[M][N] = combo(M-1,N) + combo(M-1,N-1);
    }

}
