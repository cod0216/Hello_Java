import java.util.*;
import java.io.*;

public class Main {
    static int N, R, Q, cnt, size[];
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input[] = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        Q = Integer.parseInt(input[2]);
        
        visited = new boolean[N+1];
        size = new int[N+1];
        
        list = new LinkedList[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new LinkedList<>(); 
        }
        
        for(int i = 0; i <N-1; i++){
            input = buffer.readLine().split(" ");
            int n = Integer.parseInt(input[0]); 
            int m = Integer.parseInt(input[1]);
            
            list[n].add(m);
            list[m].add(n);
        }
        
        init(R);
        
        for(int i = 0; i < Q; i++){
            int q = Integer.parseInt(buffer.readLine());
            System.out.println(size[q]);
        }

    }
    
    public static int init(int node){
        if(size[node] != 0) return size[node];
        visited[node] = true;
        cnt = 1;
        
        for(int n : list[node]){
            if(visited[n]) continue;
            cnt += init(n);
        }
        size[node] = cnt;
        
        return size[node];
    }
}
