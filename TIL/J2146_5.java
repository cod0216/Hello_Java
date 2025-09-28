package TIL;

import java.io.*;
import java.util.*;

public class J2146_5 {
    static int N, map[][], ans = Integer.MAX_VALUE;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int num = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    setNumber(i,j, num);
                    num++;
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] > 0) makeLeg(i,j,map[i][j]);
            }
        }

        System.out.println(ans-1);
    }

    public static void makeLeg(int x, int y, int n){
        visited = new boolean[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y, 0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int cn = cur[2];

            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                int nc = cn + 1;
                if(isIn(nx,ny) && !visited[nx][ny]){
                    if(map[nx][ny] == 0){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny,nc});
                    } else if(map[nx][ny] != n){
                        ans = Math.min(ans,nc);
                    }
                }
            }
        }
    }

    public static void setNumber(int x, int y, int n){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        map[x][y] = n;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] == 1){
                    map[nx][ny] = n;
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }
    public static boolean isIn(int x, int y){
        return x>=0 && y >= 0 && x < N && y < N;
    }
}
