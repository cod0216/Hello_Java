import java.util.*;
import java.io.*;
public class Main {
    static int N, M, target[];
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        target = new int[N+1];
        visited = new boolean[N+1];
        list = new LinkedList[N+1];
        int[] dist = new int[N+1];
        
        for(int i = 0 ; i <=N; i++) list[i] = new LinkedList<>();
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);            
            
            list[start].add(end);
            target[end] +=1;
        }
        
        LinkedList<Integer> queue = new LinkedList<>();
        int cnt = 1;
        for(int i = 1 ; i <= N; i++){
            if(target[i] == 0) {
                visited[i] = true;
                queue.offer(i);
                dist[i] = cnt;
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt++;
            for(int i = 0 ; i < size; i++){
                int subject = queue.poll();
                for(int s : list[subject]){
                    if(target[s] != 0){
                        target[s] -= 1;
                        if(target[s] == 0 && !visited[s]){
                            queue.offer(s);
                            visited[s] = true;
                            dist[s] = cnt;
                        } 
                    }
                }    
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1 ; i <= N; i++){
            sb.append(dist[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
