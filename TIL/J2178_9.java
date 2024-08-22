package TIL;

import java.io.*;
import java.util.*;


public class J2178_9 {
    static int[][] arr;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = { 1, 0, -1, 0};
    static int x;
    static int y;
    static int cnt;

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        arr = new int[x][y];
        visited = new boolean[x][y];

        for(int i = 0 ; i < x; i++ ){
            String a = buffer.readLine();
            for(int j = 0 ; j < y; j++){
                arr[i][j] = Integer.parseInt(a.substring(j,j+1));
            }
        }

        cnt = 1;
        BFS(0,0);
        System.out.println(arr[x-1][y-1]);
    }

    public static void BFS(int a, int b){
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{a,b});
        visited[a][b] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();

            for(int i = 0 ; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < x && ny < y && !visited[nx][ny]){
                    if(arr[nx][ny] == 1){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                        arr[nx][ny] = arr[now[0]][now[1]] +1;
                    }
                }
            }
            cnt++;
        }
    }

}
