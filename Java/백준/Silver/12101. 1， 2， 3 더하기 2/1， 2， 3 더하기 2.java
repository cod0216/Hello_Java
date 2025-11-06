import java.util.*;
import java.io.*;

public class Main {
    static int N, M, cnt, ans[];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        ans = new int[N+1];
        
        dfs(0,0);    
        System.out.print(-1);
    }
    
    public static void dfs(int v,int idx){
        if(v > N || idx > N) return;
        if(v == N){
            cnt++;
            if(cnt == M){
                for(int i = 0 ; i < idx-1; i++) {
                    System.out.print(ans[i] + "+");

                }
                System.out.print(ans[idx-1]);
                System.exit(0);
            }
        }
        
        for(int i = 1; i <= 3; i++){
            ans[idx] = i;
            dfs(v+i, idx+1);
        }
    }
    
}
