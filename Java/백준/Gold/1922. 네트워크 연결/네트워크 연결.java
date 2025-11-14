import java.util.*;
import java.io.*;

public class Main {
    static int[] p;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(buffer.readLine());
        int M = Integer.parseInt(buffer.readLine());
        p = new int[N+1];
        
        for(int i = 0 ; i <= N; i++){
            p[i] = i;
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        for(int i = 0 ; i < M; i++){
            String[] input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            
            queue.offer(new int[]{s,e,w});
            
        }
        
        int cnt = 0;
        int ans = 0;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if( find(cur[0]) != find(cur[1])){
                union(cur[0], cur[1]);
                cnt++;
                ans += cur[2];
            }
            
            if(cnt == N-1) break;
        }
        
        System.out.println(ans);
    }
    
    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));
        
        p[max] = min;
        
    }
    public static int find(int n){
        if(p[n] != n) return p[n] = find(p[n]);
        return n;
    }
}
