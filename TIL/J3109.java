package TIL;

import java.io.*;
import java.util.*;

public class J3109 {

    static char[][] map;
    static int cnt;
    static boolean[][] visited;
    static int R;
    static int C;
    static int[] dx = new int[]{-1, 0, 1};
    static int[] dy = new int[]{1, 1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

         R = Integer.parseInt(input[0]);
         C = Integer.parseInt(input[1]);

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String str = buffer.readLine();
            for(int j = 0; j < C; j++){
                map[i][j] = str.charAt(j);
            }
        }

        cnt=0;
        for (int i = 0; i < R; i++) {
            if(pip(i,0)) {
                cnt++;
            }
        }


        System.out.println(cnt);
    }
    public static boolean pip(int x, int y){
        if(y == C-1){
            return true;
        }
        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx< R && ny< C && map[nx][ny] == '.' && !visited[nx][ny]){
                visited[nx][ny] = true;
                if(pip(nx,ny)) return true;
            }
        }
        return false;
    }
}
