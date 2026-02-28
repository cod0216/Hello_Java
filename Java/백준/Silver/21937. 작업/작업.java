import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int arr[] = new int[N+1];
        
        LinkedList<Integer>[] list = new LinkedList[N+1];
        
        for(int i = 0; i <= N ; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0 ; i < M; i++){
            input = buffer.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            arr[b] += 1;
            list[b].offer(a);
        }
        
        boolean[] visited = new boolean[N+1];
        LinkedList<Integer> queue = new LinkedList<>();
        int X = Integer.parseInt(buffer.readLine());
        int ans = 0;
        for(int v : list[X]){
            queue.offer(v);
            visited[v] = true;
            ans += 1;
        }
        while(!queue.isEmpty()){
            int n = queue.poll();
            for(int v : list[n]){
                if(visited[v]) continue;
                visited[v] = true;
                queue.offer(v);
                ans++;
            }
        }
        System.out.println(ans);
        
    }
}
