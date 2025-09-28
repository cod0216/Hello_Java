package TIL;

import java.io.*;
import java.util.*;


public class J2573_5 {
    static int N, M, map[][];
    static LinkedList<int[]> dir;
    static boolean[][] visited;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        dir = new LinkedList<>();
        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] != 0 ) dir.add(new int[]{i,j});
            }
        }
        int year = 0;

        while(true){
            int count = 0;
            malt();
            visited = new boolean[N][M];
            int size = dir.size();
            for (int[] i : dir) {
                if(map[i[0]][i[1]] == 0 || visited[i[0]][i[1]]) continue;
                inspect(i[0], i[1]);
                count++;
            }

            year++;
            if(count > 1) break;
            if(count == 0) {
                year = 0;
                break;
            }
        }
        System.out.println(year);
    }

    public static void inspect(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int d = 0; d < 4; d++){
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if(isIn(nx,ny) && !visited[nx][ny] && map[nx][ny] != 0 ){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny});
                }
            }
        }
    }
    public static void malt(){
        Queue<int[]> queue = new LinkedList<>();
        for(int[] cur : dir){
            int x = cur[0];
            int y = cur[1];
            if(map[x][y] == 0 )continue;
            queue.offer(new int[]{x,y});
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<int[]> temp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = dx[d] + x;
                    int ny = dy[d] + y;

                    if (isIn(nx, ny) && map[nx][ny] == 0) {
                        temp.add(new int[]{x, y, 1});
                    }
                }
            }
            for (int[] t : temp) {
                int tx = t[0];
                int ty = t[1];
                int tn = t[2];
                map[tx][ty] -= tn;
                if(map[tx][ty] <0) map[tx][ty] = 0;
            }
        }
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
