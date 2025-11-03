import java.io.*;
import java.util.*;

class Info{
    int s;
    int e;
    int w;
    
    public Info(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    } 
}

public class Main {
    static int N, M;
    static LinkedList<Info> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        long INF = Long.MAX_VALUE/4;
        
        list = new LinkedList[N+1];
        long[] dist = new long[N+1];
        Arrays.fill(dist, INF);
        
        for(int i = 0 ; i <= N; i++) list[i] = new LinkedList<>();
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            
            list[start].add(new Info(start, end, weight));
        }
        
        dist[1] = 0;
        
        for(int i = 1; i < N; i++){
            boolean check = false;
            for(int s = 1; s <= N; s++){
                if(dist[s] == INF) continue;
                for(Info cur : list[s]){
                    if(dist[cur.e] > dist[cur.s] + cur.w){
                        dist[cur.e] = dist[cur.s] + cur.w;
                        check = true;
                    }
                }
            }
            if(!check) break;
        }
        
        
        for(int s = 1; s <= N; s++){
            if(dist[s] == INF) continue;
            for(Info cur : list[s]){
                if(dist[cur.e] > dist[cur.s] + cur.w){
                    System.out.println(-1);
                    return;
                }
            }
        }
        
        for(int s = 2; s <= N; s++){
            System.out.println(dist[s] == INF ? -1 : dist[s]);
        }
    }
}
