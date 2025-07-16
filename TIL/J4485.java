package TIL;

import java.io.*;
import java.util.*;

public class J4485 {
    static BufferedReader buffer;
    static int[][] map;
    static boolean[][] visited;
    static int[][] dist;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};

    public static void main(String[] args) throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
        int round = 0;
        while(true){

            int n = Integer.parseInt(buffer.readLine());

            if(n == 0) break;

            initializeMap(n);
            letGo(0,0, n);
            print(n, ++round);
        }

    }

    private static void print(int n, int round) {
        System.out.println("Problem " + round + " : " + dist[n-1][n-1]);
    }

    private static void letGo(int x, int y, int n) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));

        dist[x][y] = map[x][y];
        pq.offer(new int[]{x, y, dist[x][y]});

        while(!pq.isEmpty()){
            int[] dir = pq.poll();

            if (dist[dir[0]][dir[1]] < dir[2]) continue;



            for (int i = 0; i < 4; i++) {
                int nx= dir[0] + dx[i];
                int ny= dir[1] + dy[i];
                if(isIn(nx,ny,n)) {
                    if (dist[nx][ny] > map[nx][ny] + dist[dir[0]][dir[1]]) {
                        dist[nx][ny] = map[nx][ny] + dist[dir[0]][dir[1]];
                        pq.offer(new int[]{nx, ny, dist[nx][ny]});
                    }
                }
            }
        }
    }

    private static boolean isIn(int x, int y, int n){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
    private static void initializeMap(int n) throws IOException {
        map = new int[n][n];
        visited = new boolean[n][n];
        dist = new int[n][n];

        for (int i = 0; i <n; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j <n; j++) {
               map[i][j] = Integer.parseInt(input[j]);
               dist[i][j] = Integer.MAX_VALUE;
            }
        }
    }
}
