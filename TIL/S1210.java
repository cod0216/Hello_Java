package TIL;

import java.io.*;
import java.util.*;

public class S1210 {
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = new int[]{0, 0, -1};
    static int[] dy = new int[]{-1, 1, 0};
    static int t;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while(10>t) {
            int T= Integer.parseInt(buffer.readLine());
            field = new int[100][100];
            visited = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                String[] input = buffer.readLine().split(" ");
                for (int j = 0; j < 100; j++) {
                    field[i][j] = Integer.parseInt(input[j]);
                }
            }
            t++;
            for (int i = 0; i < 100; i++) {
                if (field[99][i] == 2) {
                    go(99, i);
                }
            }


        }
    }

    public static void go(int x, int y){
        if(x == 0){
            System.out.println("#" + t + " " + y);
        }

        for(int i = 0; i < 3; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >=0 && ny>=0 && nx<100 && ny < 100 && field[nx][ny]==1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                go(nx, ny);
                break;
            }
        }
    }
}
