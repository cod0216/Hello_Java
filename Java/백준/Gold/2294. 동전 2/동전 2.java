import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] coins = new int[N];
        for(int i = 0 ; i < N; i++){
            coins[i] = Integer.parseInt(buffer.readLine());
        }
        
        int[] dp = new int[M+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        
        for(int i = 0;  i< N; i++){        
            for(int j = coins[i]; j <= M; j++){
                dp[j] = Math.min(dp[j], dp[j - coins[i]]+1);
            }
        }
        
        System.out.println(dp[M] == 100001 ? -1 : dp[M]);
    }                           
}
