import java.util.*;
import java.io.*;

/*
1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
    바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
    바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
3. 현재 칸의 주변 $4$칸 중 청소되지 않은 빈 칸이 있는 경우,
    반시계 방향으로 $90^\circ$ 회전한다.
    바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
    1번으로 돌아간다.
*/

public class Main {
    static int N, M, map[][], state, robotX, robotY, clean;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        input = buffer.readLine().split(" ");
        
        robotX = Integer.parseInt(input[0]);
        robotY = Integer.parseInt(input[1]);
        state = Integer.parseInt(input[2]);
        
        map = new int[N][M];
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j < M; j++){            
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        play();
        System.out.println(clean);
    }
    public static void play(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{robotX, robotY, state});
        while(!queue.isEmpty()){
            boolean isNot = true;
            int[] cur = queue.poll();
            int x = cur[0]; int y = cur[1]; int s = cur[2];
            if(map[x][y] != 2) clean(x,y); 
            for(int i = 0; i < 4; i++){
                s = (s + 3)%4;
                int nx = x + dx[s];
                int ny = y + dy[s];
                if(isIn(nx,ny) && map[nx][ny] == 0 ){
                    queue.offer(new int[]{nx, ny, s});
                    isNot = false;
                    break;
                }
            }
            if(isNot){
                int v = (s + 2)%4;
                int nx = x + dx[v]; int ny = y + dy[v];
                if(isIn(nx,ny) && map[nx][ny] != 1 ){
                    queue.offer(new int[]{nx, ny, s});
                } else if(isIn(nx,ny) && map[nx][ny] == 1 ) return;
            }
        }
    }
    
    public static void clean(int x, int y){
        map[x][y] = 2;
        clean++;
    }
    
    public static boolean isIn(int x, int y){
        return x >=0 && y >= 0 && x < N && y < M;
    }
}
