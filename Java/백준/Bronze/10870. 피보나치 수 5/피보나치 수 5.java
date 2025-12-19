import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        long[] dp = new long[N+1];
        if(N == 0){
            System.out.println(0);
            return;
        }
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i = 2; i <= N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        System.out.println(dp[N]);
    }
}
