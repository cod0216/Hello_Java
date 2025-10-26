import java.util.*;
import java.io.*;

public class Main {
    static int A[], M, N;
    public static int find(int n){
        if(A[n] != n) return A[n] = find(A[n]);
        return A[n];
    }
    
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        
        A[max] = min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        A = new int[N+1];
        
        for(int i = 1; i <= N; i++){
            A[i] = i;
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            
            pq.offer(new int[]{s,e,w});
        }
        int ans = 0;
        int max = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int s = cur[0]; int e = cur[1]; int w = cur[2];
            if(find(s) != find(e)){
                union(s, e);
                ans +=w;
                max = Math.max(w, max);
            }
        }
        System.out.println(ans-max);
    }
}
