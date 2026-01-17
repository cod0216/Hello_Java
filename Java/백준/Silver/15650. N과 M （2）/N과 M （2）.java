import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        dfs(0, 0, new int[M]);
        System.out.println(sb.toString());
    }
    
    public static void dfs(int s, int now,int[] temp){
        if(now == M){
            for(int i = 0 ; i < now; i++) sb.append(temp[i]).append(" ");
            sb.append("\n");
            return;
        }
        
        if(now > M) return;
        
        for(int i = s+1; i <= N; i++){
            temp[now] = i;
            dfs(i, now+1, temp);
        }
    }
}
