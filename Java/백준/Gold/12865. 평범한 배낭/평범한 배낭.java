import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        int[] item = new int[N+1];
        int[] weight = new int[N+1];
        int[][] dp = new int[N+1][K+1];
        for(int i = 0 ; i < N ; i++){
            input = buffer.readLine().split(" ");
            item[i+1] = Integer.parseInt(input[0]);
            weight[i+1] = Integer.parseInt(input[1]);
        }
        
        for(int i = 1 ; i <= N; i++){
            for(int j = 1; j <= K; j++){
                dp[i][j] = dp[i-1][j];
                if(item[i] <= j){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-item[i]] + weight[i]);
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
