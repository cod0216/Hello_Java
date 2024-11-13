package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J4963 {
    static int[][] map;
    static int w, h;
    static int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = new int[]{1, 0, -1, -1, 1, 1, -1, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        while(true) {
            String[] input = buffer.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);
            if( w ==0 && h == 0) break;
            visited = new boolean[h][w];

            map= new int[h][w];
            for(int i = 0; i < h; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0; j < w; j++){
                    map[i][j]= Integer.parseInt(input[j]);
                }
            }
            int cnt = 0;
            for(int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        dfs(i,j);
                        cnt++;
                    }
                }
            }


            System.out.println(cnt);
        }//while end;
    }
    public static void dfs(int x, int y){
        if(visited[x][y]) return;
        visited[x][y] = true;
        for(int i = 0; i < 8; i++) {
            int nx = x +dx[i];
            int ny = y + dy[i];
            if(isIn(nx,ny) && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
    public static boolean isIn(int x, int y){
        return x >=0 && y>= 0 && x<h && y < w;
    }
}
