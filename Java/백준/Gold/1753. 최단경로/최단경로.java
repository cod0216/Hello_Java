import java.util.*;
import java.io.*;

class Info implements Comparable<Info>{
    int e;
    int w;
    
    public Info(int e, int w){
        this.e = e;
        this.w = w;
    }
    
    public int compareTo(Info o){
        return this.w - o.w;
    }
    
}

public class Main {
    static int N, M, dist[];
    static LinkedList<Info>[] list;     
    static boolean visited[];
    static int INF = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, INF);
        
        int k = Integer.parseInt(buffer.readLine());
        list = new LinkedList[N+1];
        
        for(int i = 0 ; i <= N; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0 ; i < M; i++){
            input = buffer.readLine().split(" ");
            
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            
            list[s].add(new Info(e, w));
        }
        
        PriorityQueue<Info> queue = new PriorityQueue<>();
        
        queue.offer(new Info(k, 0));
        
        dist[k] = 0;
        visited[k] = true;
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            visited[cur.e] = true;
                    
            for(Info now : list[cur.e]){
                if(!visited[now.e] && dist[now.e] > dist[cur.e] + now.w){                
                    dist[now.e] = dist[cur.e] + now.w;
                    queue.offer(new Info(now.e, dist[now.e]) );
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i<=N; i++){
            sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
