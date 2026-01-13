import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K, map[][], cnt, max;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);        
        
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        
        for(int i = 0; i < K; i++){
            input = buffer.readLine().split(" ");
            int sx = Integer.parseInt(input[0]);
            int sy = Integer.parseInt(input[1]);
            int ex = Integer.parseInt(input[2]);
            int ey = Integer.parseInt(input[3]);
            // System.out.println("sx : " + sx + ", sy : " + sy + ", ex : " + ex + ", ey : " + ey );
            
            for(int z = sx; z < ex; z++){
                for(int j = sy; j< ey; j++){                
                    map[j][z] = 1;
                }
            }
        }
    
        
        LinkedList<Integer> list = new LinkedList<>();
        int idx=0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){            
                if(!visited[i][j] && map[i][j] == 0) {
                    idx++;
                    list.add(bfs(i,j));
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(list);
        for(int i = 0; i < idx; i++){
            System.out.print(list.get(i) + " ");
        }
        
    }
    
    public static int bfs(int x, int y){
        cnt++;
        int max = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            max += 1;
            int[] cur = queue.poll();
            int cx = cur[0]; int cy = cur[1];
            for(int i = 0 ; i < 4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] != 1){
                    visited[nx][ny]=true;
                    queue.offer(new int[]{nx,ny});
                    
                }
            }    
        }
        return max;
    }
    
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
