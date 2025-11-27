import java.util.*;
import java.io.*;

public class Main {
    static int N, w[], dp[][];
    static LinkedList<Integer> ans, list[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer  = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        w = new int[N+1];
        for(int i = 0; i < N; i++){
            w[i+1] = Integer.parseInt(input[i]);
        }
        
        dp = new int[N+1][2];
        list = new LinkedList[N+1];
        ans = new LinkedList<>();
        
        for(int i = 0 ; i <= N; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i <N-1; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            list[a].add(b);
            list[b].add(a);
        }
        
        dfs(0,1);
        trace(0, 1, false);
        
        System.out.println(Math.max(dp[1][0], dp[1][1]));
        Collections.sort(ans);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void trace(int before, int cur, boolean isCheck){
        boolean isNow = false;


        // 부모 ㄴㄴ -> 자식 ㅇㅇ
        if (!isCheck && dp[cur][1] > dp[cur][0]) {
            ans.add(cur);
            isNow = true;
        }
        
        for(int now : list[cur]){
            if(now == before) continue;
            trace(cur, now, isNow);
        }
    }
    
    public static void dfs(int before, int cur){
        dp[cur][0] = 0;
        dp[cur][1] = w[cur];
        
        for(int now : list[cur]){
            if(now == before) continue;
            dfs(cur, now);
            dp[cur][1] += dp[now][0];
            dp[cur][0]  += Math.max(dp[now][1], dp[now][0]);
        }
        
    }
}
