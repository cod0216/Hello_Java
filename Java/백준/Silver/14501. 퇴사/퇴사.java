import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int[] time = new int[N+1];
        int[] money = new int[N+1];
        
        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            time[i+1] = Integer.parseInt(input[0]);
            money[i+1] = Integer.parseInt(input[1]);
        }
        int[] dp = new int[N+2];
        for(int i = N; i >= 1; i--){
            dp[i] = dp[i+1];
            
            int next = i + time[i];
            if(next <= N+1){
                dp[i] = Math.max(dp[i], money[i] + dp[next]);
            }
        }
        
        System.out.println(dp[1]);
    }
}
