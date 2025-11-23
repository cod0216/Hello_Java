import java.util.*;
import java.io.*;

public class Main {
    static int N, cnt, dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        dp = new int[N+1];
        
        dp[0] = 0;
        if(N == 1){
            System.out.println(1);
            return;
        }
        if(N == 2){
            System.out.println(2);
            return;
        }
        dp[1] = 1;
        dp[2] = 2;
        
        
        for(int i = 3; i <= N; i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }
        System.out.println(dp[N]);
        
    }

}
