import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[][] dp = new int[N+1][M+1];

        int[] item = new int[N+1];
        int[] value = new int[N+1];

        for(int i = 1; i <= N; i++){
            input = buffer.readLine().split(" ");
            
            int w = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);            
            
            item[i] = w;
            value[i] = v;
        }
        
        for(int i = 1; i <= N; i++){
            for(int j = 0; j <= M; j++){
                dp[i][j] = dp[i-1][j];
                if(item[i] <= j) dp[i][j] = Math.max(dp[i-1][j-item[i]] + value[i], dp[i][j]);
            }
        }        
            System.out.println(dp[N][M]);
    }
}
