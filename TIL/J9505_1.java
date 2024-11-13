package TIL;

import java.util.*;
import java.io.*;


public class J9505_1 {
    static char ship[];
    static int s, n, m, map[][], dis[][], life[];
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{1,0,-1,0};
    static boolean visited[][];
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;
        while(T>t){
            String[] input = buffer.readLine().split(" ");
            s = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            n = Integer.parseInt(input[2]);

            map = new int[n][m];
            dis = new int[n][m];
            ship = new char[s];
            life = new int[s];
            visited = new boolean[n][m];

            for(int i = 0 ; i < s; i++){
                input = buffer.readLine().split(" ");
                ship[i] = input[0].charAt(0);
                life[i] = Integer.parseInt(input[1]);
            }

            int targetX =0;
            int targetY =0;
            for(int i= 0; i< n; i++){
                input = buffer.readLine().split("");
                for(int j= 0; j< m; j++) {
                    char c = input[j].charAt(0);
                    map[i][j] = getIndex(c);
                    if(map[i][j] ==0){
                        targetX = i;
                        targetY = j;
                    }
                }
            } // input end

            dijkstra(targetX,targetY);
            t++;
        }

    }
    public static void dijkstra(int x, int y){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        pq.offer(new int[]{x,y,0});
        for(int i = 0; i <n; i++) Arrays.fill(dis[i],Integer.MAX_VALUE);
        dis[x][y] = 0;
        while(!pq.isEmpty()){

            int[] cur = pq.poll();
            int cx = cur[0];
            int cy = cur[1];
            visited[cx][cy] = true;
            for(int d = 0 ; d<4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(!isIn(nx,ny)){
                    System.out.println(cur[2]);
                    return;
                }
                if(isIn(nx,ny) && !visited[nx][ny]){
                    if(dis[nx][ny] > dis[cx][cy] + life[map[nx][ny]-1]){
                        dis[nx][ny] = dis[cx][cy] + life[map[nx][ny]-1];
                        pq.offer(new int[]{nx,ny, dis[nx][ny]});
                    }
                }
            }
        }// pq while end
    }
    public static int getIndex(char c){
        for(int i = 0; i < s; i++){
            if(ship[i] == c){
                return i+1;
            }
        }
        return 0;
    }

    public static boolean isIn(int x, int y) {
        return x >=0 && y>= 0 && x < n && y< m;
    }
}
