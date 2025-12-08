import java.util.*;
import java.io.*;

public class Main {
    static int N, p[];
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        
        list = new LinkedList[N+1];
        visited = new boolean[N+1];
        p = new int[N+1];
        
        for(int i = 1 ; i <= N ; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 1 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            list[s].add(e);
            list[e].add(s);
        }
        
        dfs(0,1);
        for(int i = 2; i<= N; i++){
            System.out.println(p[i]);
        }
    }
    public static void dfs(int before, int node){
        visited[node] = true;
        p[node] = before;
        for(int now : list[node]){
            if(visited[now])continue;
            dfs(node, now);
        }
    }
}
