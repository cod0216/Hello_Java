import java.util.*;
import java.io.*;

public class Main {
    static int N,M,map[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split("");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        queue.offer(new int[]{0,0,0});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0]; int cy = cur[1]; int cl = cur[2];
            if(cx == N-1 && cy == M-1) {
                System.out.println(cl+1);
                return;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = dx[i] + cx;
                int ny = dy[i] + cy;
                int nl = cur[2]+1;
                if(isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny,nl});
                }
            }
        }

    }
    
    public static boolean isIn(int x, int y){
        return x >=0 && y>= 0 && x < N && y<M;
    }
}
