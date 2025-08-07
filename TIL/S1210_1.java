package TIL;


import java.io.*;
import java.util.*;

public class S1210_1 {
    static int[][] map = new int[100][100];
    static int dx[] = new int[]{-1,0, 0};
    static int dy[] = new int[]{0,-1,1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){
            for(int i = 0; i < 100; i++){
                String[] input = buffer.readLine().split(" ");
                for(int j = 0; j < 100; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }
            ans = 0;
            for(int i = 0; i < 100; i++){
                if(map[99][i] == 2){
                    start(99, i, new boolean[100][100]);
                }
            }
            t++;
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void start (int x, int y, boolean[][] visited){

        for(int i = 0 ; i < 3; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(!isIn(nx,ny))continue;
            if(visited[nx][ny]) continue;

            if (map[nx][ny] == 1) {
                if(nx == 0) {
                    ans=ny;
                    return;
                }
                visited[nx][ny] = true;
                start(nx, ny, visited);
                visited[nx][ny] = false;
            }
        }
        return;
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y >=0 && x < 100 && y < 100;
    }
}
