import java.util.*;
import java.io.*;

public class Main {
    static int N, start, max=0;
    static boolean[] visited;
    
    static LinkedList<int[]>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(buffer.readLine());
        list = new LinkedList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < N-1; i++){
            String[] input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        visited = new boolean[N+1];
        bfs(1,0);
        visited = new boolean[N+1];
        max = 0;
        bfs(start,0);        
        System.out.println(max);
        
        
    }
    public static void bfs(int node, int dis){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{node,dis});
        visited[node] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] now : list[cur[0]]){
                if(!visited[now[0]]){
                    visited[now[0]] = true;
                    queue.offer(new int[]{now[0], now[1]+cur[1]});
                    if(now[1]+cur[1] > max){
                        start = now[0];
                        max = now[1]+cur[1];
                    }
                }
            }
        }
    }
}
