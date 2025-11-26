import java.util.*;
import java.io.*;

public class Main {
    static int N, people[], dp[][];
    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        people = new int[N+1];
        list = new LinkedList[N+1];
        for(int i = 0; i < N; i++){
            people[i+1] = Integer.parseInt(input[i]);
            list[i+1] = new LinkedList<>();
        }
        
        for(int i = 0; i< N-1; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            list[a].add(b);
            list[b].add(a);
        }
        
        dp= new int[N+1][2];
        
        dfs(0,1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    public static void dfs(int before, int cur){
        dp[cur][0] = 0;
        dp[cur][1] = people[cur];
        
        for(int now : list[cur]){
            if(now == before) continue;
            dfs(cur, now);
            dp[cur][1] += dp[now][0];
            dp[cur][0] += Math.max(dp[now][0], dp[now][1]);
        }
    }
}
