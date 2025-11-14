import java.util.*;
import java.io.*;

public class Main {
    static int N, M, p[], s[];
    static long R, ans;
    static LinkedList<Integer> check[];
    static boolean visited[];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Long.parseLong(input[2]); 
        
        if (M <= 1) {
            System.out.println("YES");
            return;
        }
        
        s = new int[N+1];
        p = new int[N+1];
        input = buffer.readLine().split(" ");
        check  = new LinkedList[N+1];
        visited = new boolean[N+1];
        
        for(int i = 1 ; i <= N; i++){
            check[i] = new LinkedList<>();
        }
        
        for(int i = 1 ; i <= N; i++){
            s[i] = Integer.parseInt(input[i-1]);
            p[i] = i;
        }
        for(int i = 0 ; i < M; i++){        
            input = buffer.readLine().split(" ");            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            int max = Math.max(a,b);
            int min = Math.min(a,b);            
            check[max].add(min);
            
        }
        
        for (int i = 1; i < N; i++) {
            int a = i;
            int b = i + 1;
            int max = Math.max(a, b);
            int min = Math.min(a, b);

            if (!check[max].contains(min)) {
                union(a, b);
            }
        }
        
        {
            int a = N;
            int b = 1;
            int max = Math.max(a, b); // N
            int min = Math.min(a, b); // 1
            if (!check[max].contains(min)) {
                union(a, b);
            }
        }

        
        long[] minCost = new long[N+1];
        Arrays.fill(minCost, Long.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            if (s[i] < minCost[root]) {
                minCost[root] = s[i];
            }
        }

        ans = 0L;
        Arrays.fill(visited, false);
        for (int i = 1; i <= N; i++) {
            int root = find(i);
            if (!visited[root]) {
                visited[root] = true;
                ans += minCost[root];
            }
        }
        
        System.out.println(ans <= R ? "YES" : "NO");
    }
    
    public static int find(int n){
        if(p[n] != n) return p[n] = find(p[n]);
        return n;
    }
    
    public static boolean union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));
        p[max] = min;
        return true;
    }
}
