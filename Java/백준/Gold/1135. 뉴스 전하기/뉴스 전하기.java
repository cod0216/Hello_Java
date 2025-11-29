import java.util.*;
import java.io.*;

public class Main {
    static int N, dp[];
    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        dp = new int[N];
        
        String[] input = buffer.readLine().split(" ");
        list = new LinkedList[N];
        
        for(int i = 0; i < N; i++){
            list[i] = new LinkedList<>();
        }
        int s = 0;
        for(int i = 0; i < N; i++){
            int p = Integer.parseInt(input[i]);
            if(p == -1) s = i;
            else list[p].add(i);
        }
        System.out.println(dfs(s));
    }
    
    public static int dfs(int cur){
        for(int now : list[cur]){
            dp[now] = 1 + dfs(now);
        }
        Collections.sort(list[cur], (a, b) -> dp[b]-dp[a]);
        int ans = 0;
        for(int i = 0 ; i< list[cur].size(); i++){
            int n = list[cur].get(i);
            dp[n] += i;
            ans = Math.max(ans,dp[n]);
        }
        return ans;
    }
}
