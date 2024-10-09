package TIL;

import java.io.*;
import java.util.*;

public class J1584 {
    static int[][] map= new int[501][501];
    static int[][] distance= new int[501][501];
    static int[] dx = new int[]{1,0, -1,0};
    static int[] dy = new int[]{0, 1, 0,-1};
    static boolean[][] visited = new boolean[501][501];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int warring = Integer.parseInt(buffer.readLine());
        for(int i = 0; i<501; i++){
            Arrays.fill(distance[i],Integer.MAX_VALUE/2);
        }

        for(int i = 0 ; i < warring; i++){
            input = buffer.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int m1 = Integer.parseInt(input[1]);
            int n2 = Integer.parseInt(input[2]);
            int m2 = Integer.parseInt(input[3]);

            int x1 = Math.min(n1,n2);
            int x2 = Math.max(n1,n2);

            int y1 = Math.min(m1,m2);
            int y2 = Math.max(m1,m2);
            for(int y = y1; y <=y2; y++){
                for(int x = x1 ; x <= x2; x++){
                    map[y][x] = 1;
                }
            }
        } //warringZone input end

        int death = Integer.parseInt(buffer.readLine());
        for(int i = 0 ; i < death; i++){
            input = buffer.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int m1 = Integer.parseInt(input[1]);
            int n2 = Integer.parseInt(input[2]);
            int m2 = Integer.parseInt(input[3]);

            int x1 = Math.min(n1,n2);
            int x2 = Math.max(n1,n2);

            int y1 = Math.min(m1,m2);
            int y2 = Math.max(m1,m2);

            for(int y = y1; y <=y2; y++){
                for(int x = x1 ; x <= x2; x++){
                    map[y][x] = 2;
                }
            }
        } // deathZone input end;

        dijkstra();
        System.out.println(distance[500][500] == Integer.MAX_VALUE/2 ? -1 : distance[500][500]);
    }

    public static void dijkstra(){
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pqueue.offer(new int[]{0,0,0});
        distance[0][0] = 0;
        map[0][0] = 0;

        while(!pqueue.isEmpty()){
            int[] cur = pqueue.poll();
            int x = cur[0]; int y = cur[1];

            if(x ==500 && y == 500) return;

            if(visited[x][y]) continue;;
            visited[x][y] = true;

            for(int i = 0 ; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isIn(nx,ny) && distance[nx][ny] > distance[x][y] + map[nx][ny]){
                    if(map[nx][ny] == 2) continue;
                    distance[nx][ny] = distance[x][y] + map[nx][ny];
                    pqueue.offer(new int[]{nx,ny, distance[nx][ny]});
                }
            }

        }// pq while end
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y>= 0 && x<501 && y<501;
    }
}
