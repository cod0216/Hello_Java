import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<int[]>[] list;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int M = Integer.parseInt(buffer.readLine());
        dist = new int[N+1];
        
        list = new LinkedList[N+1];
        visited = new boolean[N+1];

        for(int i = 1 ; i  <= N; i++){
            list[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < M; i++){
            String[] input = buffer.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            list[a].add(new int[]{b, c});
        }

        String[] input = buffer.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        
        play(s, e);
        System.out.println(dist[e]);
        
    }
    
    public static void play(int s, int e){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{s, 0});
        dist[s] = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int[] now : list[cur[0]]){
                if(dist[now[0]] > dist[cur[0]] + now[1]){
                    dist[now[0]] = dist[cur[0]] + now[1];
                    queue.offer(new int[]{now[0],dist[now[0]]});
                }
            }
        }
    }
}
