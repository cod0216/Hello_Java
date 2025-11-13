import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][], dist[][], dx[], dy[];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        dist = new int[N][M];        
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }           
        }
        
        int d = Integer.parseInt(buffer.readLine());
        dx = new int[d]; dy = new int[d];
        
        for(int i = 0; i < d; i++){
            input = buffer.readLine().split(" ");    
            
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            dx[i] = x;
            dy[i] = y;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        for(int i = 0; i < M; i++){
            if(map[0][i] == 1){ 
                queue.offer(new int[]{0,i,0});            
                dist[0][i] = 0;
            }
        }

        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            // System.out.println("x : " + cur[0] + ", y : " + cur[1] + ", w : " + cur[2]);
            if(cur[0] == N-1){
                System.out.println(cur[2]); 
                return;
            } 
            
            for(int z = 0 ; z < d; z++){
                int nx = cur[0] + dx[z];
                int ny = cur[1] + dy[z];
                
                if(isIn(nx,ny) && map[nx][ny] == 1 && dist[nx][ny] > dist[cur[0]][cur[1]] + cur[2]+1){
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    queue.offer(new int[]{nx,ny,dist[nx][ny]});
                    // System.out.println("x :" + nx + ", y :" + ny + ", w :" + dist[nx][ny] );
                }
            }
        }
        
        System.out.println(-1);
        
    }
    
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
