package TIL;

import java.io.*;
import java.util.*;

public class J10026 {
    static char[][] map;
    static char[][] map2;
    static int N;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean[][] visited;
    static int cnt1;
    static int cnt2;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

         N = Integer.parseInt(buffer.readLine());
         map = new char[N][N];
         map2 = new char[N][N];

         visited = new boolean[N][N];

         for(int i = 0; i < N; i++){
             String str = buffer.readLine();
                 map[i] = str.toCharArray();

         }

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j<N; j++){
                map2[i][j] = map[i][j];
                if(map[i][j] == 'R') map2[i][j] = 'G';
            }
        }

         cnt1 = 0;
         for(int i = 0 ; i < N; i++){
             for(int j = 0 ; j < N; j++){
                 if(!visited[i][j]) BFS1(i,j);
             }
         }
        visited = new boolean[N][N];
         cnt2 = 0;
         for(int i = 0 ; i < N; i++){
               for(int j = 0 ; j < N; j++){
                   if(!visited[i][j]) BFS2(i,j);
               }
         }
        System.out.println(cnt1 +" " + cnt2);

    }

    public static void BFS1(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] dir = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = dir[0] + dx[d];
                int ny = dir[1] + dy[d];
                if(isIn(nx,ny)){
                    if(map[dir[0]][dir[1]] == map[nx][ny] && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        cnt1++;
    }
    public static void BFS2(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] dir = queue.poll();
            for(int d = 0; d < 4; d++){
                int nx = dir[0] + dx[d];
                int ny = dir[1] + dy[d];
                if(isIn(nx,ny)){
                    if(map2[dir[0]][dir[1]] == map2[nx][ny] && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        cnt2++;
    }

    public static boolean isIn(int x, int y){
        if(x >= 0 && y >= 0 && x < N && y < N) return true;
        return false;
    }
}
