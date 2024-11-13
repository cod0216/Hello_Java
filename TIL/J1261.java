package TIL;

import java.io.*;
import java.util.*;

public class J1261 {
    static int map[][], n , m, dis[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};

    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];
        for(int i =0; i < n; i++)
        Arrays.fill(dis[i], Integer.MAX_VALUE);

        for(int i = 0 ; i< n; i++){
            input = buffer.readLine().split("");
            for(int j = 0 ; j< m; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dijkstra();
        System.out.println(dis[n - 1][m - 1]);

    }
    public static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pq.offer(new int[]{0,0,0});
        dis[0][0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cx = cur[0];
            int cy = cur[1];
            if(cx == n-1 && cy == m-1) continue;
            if(!visited[cx][cy]){
                visited[cx][cy] = true;
                for(int d = 0; d < 4; d++){
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if(isIn(nx,ny) && !visited[nx][ny]){
                        if(map[nx][ny] == 1 && dis[nx][ny] > dis[cx][cy] + 1){
                            dis[nx][ny] = dis[cx][cy] + 1;
                            pq.offer(new int[]{nx,ny,dis[nx][ny]});
                        }else if(map[nx][ny] == 0 && dis[nx][ny] > dis[cx][cy]){
                            dis[nx][ny] = dis[cx][cy];
                            pq.offer(new int[]{nx,ny,dis[nx][ny]});
                        }
                    }
                }
            }
        } // pq while end
    }

    private static boolean isIn(int x, int y) {
        return x >=0 && y>= 0 && x < n && y< m;
    }

}
