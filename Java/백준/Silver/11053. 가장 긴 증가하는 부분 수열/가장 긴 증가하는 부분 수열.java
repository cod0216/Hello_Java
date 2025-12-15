import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int ans = 0;
        String[] input = buffer.readLine().split(" ");
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N]; 
        Arrays.fill(dp,1);

        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
