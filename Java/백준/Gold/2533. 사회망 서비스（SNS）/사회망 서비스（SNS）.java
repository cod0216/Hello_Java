import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static LinkedList<Integer>[] list;
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        list = new LinkedList[N+1];
        dp = new int[N+1][2];
        for(int i = 0; i <= N; i++){
            list[i] = new LinkedList<>();
        }
        
        // no Cycle
        
        String[] input;
        for(int i = 1; i < N; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            list[a].add(b);
            list[b].add(a);
        }
        

        search(0,1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    public static void search(int before, int cur){
        dp[cur][0] = 0;
        dp[cur][1] = 1;
        
        for(int now : list[cur]){
            if(now == before) continue;
            search(cur, now);
            dp[cur][0] += dp[now][1];
            dp[cur][1] += Math.min(dp[now][1], dp[now][0]);
        }
    }
}
