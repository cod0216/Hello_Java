import java.util.*;
import java.io.*;

public class Main {
    static int N, M, parents[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        parents = new int[N+1];
        
        for(int i = 0 ; i <= N; i++){
            parents[i] = i;   
        }
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            
            int s = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);
            
            if(s == 1) System.out.println(find(parents[a]) != find(parents[b]) ? "NO" : "YES");
            else union(a,b);

        }        
    }
    public static int find(int n){
        if(parents[n] != n) return parents[n] = find(parents[n]);
        return n;
    }
    
    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));
        
        parents[max] = parents[min];
    }
}
