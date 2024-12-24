package TIL;

import java.io.*;
import java.util.*;

public class J2178_10 {
    static int n, m, map[][];
    static boolean visited[][];
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n  = Integer.parseInt(input[0]);
        m  = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i< n; i++){
            input = buffer.readLine().split("");
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs();
    }
    public static void bfs() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cx = cur[0];
            int cy = cur[1];
            if(visited[cx][cy]) continue;
            visited[cx][cy] = true;
            if(cx == n-1 && cy == m-1){
                System.out.println(cur[2]+1);
                return;
            }
            for(int i = 0 ; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny]== 1 ){
                    pq.offer(new int[]{nx,ny,cur[2] + 1});
                }
            }
        }// pq while end
    }

    public static boolean isIn(int x, int y){
        return x >=0 && y >=0 && x< n && y<m;
    }
}
