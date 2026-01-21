import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        int ans = 0;
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split("");
            for(int j = 0; j < M; j++){
                if(input[j].charAt(0) == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){            
                if(map[i][j] == 0)continue;
                visited = new boolean[N][M];
                ans = Math.max(ans, bfs(i,j));
            }
        }
        
        System.out.println(ans);
    }
    public static int bfs(int a, int b){
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[a][b]=true;
        queue.offer(new int[]{a,b, 0});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0]; int cy = cur[1]; int cw = cur[2];
            
            for(int i = 0 ; i < 4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(isIn(nx,ny) && map[nx][ny] == 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cw+1});
                    max = Math.max(cw+1, max);
                }
            }
        }
        
        return max;
    }
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
