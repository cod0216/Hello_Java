package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1937 {
    static int n, map[][], res, move[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input;

        n = Integer.parseInt(buffer.readLine());

        map = new int[n][n];
        move = new int[n][n];


        for (int i = 0; i < n; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }// input end

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(dfs(i,j), res);
            }
        }
        System.out.println(res);
    }

    public static int dfs(int x, int y){
        if(move[x][y] != 0) return move[x][y];
        move[x][y] = 1;

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(isIn(nx,ny) &&  map[nx][ny] > map[x][y]){
                move[x][y] = Math.max(move[x][y],dfs(nx,ny)+1);
            }
        }

        return move[x][y];

    }

    public static boolean isIn(int x, int y){
        return x >=0 && y>= 0 && x<n && y<n;
    }
}
