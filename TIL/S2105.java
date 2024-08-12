package TIL;

import java.io.*;
import java.util.*;

public class S2105 {
    static int max;
    static int[] dx = new int[]{1, 1, -1, -1};
    static int[] dy = new int[]{1, -1, -1, 1};
    static boolean[] visited;
    static int[][] cafeArr;
    static int startX;
    static int startY;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;

        while(T > t){
            n = Integer.parseInt(buffer.readLine());
            visited = new boolean[101];
            max = 0;
            cafeArr = new int[n][n];


            for(int i = 0; i < n; i++){
                String[] input = buffer.readLine().split(" ");
                for(int j = 0 ; j < n; j++) {
                    cafeArr[i][j] = Integer.parseInt(input[j]);
                }
            }
            for(int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    startX = i;
                    startY = j;
                    DFS(i,j, 0,0, 0);
                }
            }

            t++;
            System.out.println("#" + t + " " + max);
        }
    }
    public static void DFS(int x, int y, int depth, int cnt, int go){
        if(startX == x && startY == y && depth != 0){
            max = Math.max(cnt,max);
            return;
        }

        for(int i = go; i < 4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n){
                if(!visited[cafeArr[nx][ny]]) {
                    visited[cafeArr[nx][ny]] = true;
                    DFS(nx,ny,depth+1,cnt+1, i);
                    visited[cafeArr[nx][ny]] = false;
                }
            }
        }
    }
}
