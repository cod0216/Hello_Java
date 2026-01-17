import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int arr[], N, M;
    static boolean used[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N+1];
        used = new boolean[N+1];

        for(int i = 1 ; i <= N; i++){
            arr[i] = i;
        }
        
        dfs(0, new int[M]);
        System.out.println(sb.toString());
    }
    
    public static void dfs(int now, int temp[]){
        if(now == M){
            for(int i = 0; i < now; i++) sb.append(temp[i]).append(" ");
            sb.append("\n");
            return;
        }
        
        for(int i = 1; i <=N; i++){
            if(used[i])continue;
            used[i] = true;
            temp[now] = i;
            dfs(now+1, temp);
            used[i] = false;
        }
        
    }
}
