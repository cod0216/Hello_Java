package TIL;

import java.io.*;
import java.util.*;

public class J18405 {
    static int n, m, map[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean visited[][];

    static ArrayList<int[]> dir;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        dir = new ArrayList<>();
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][n];
        map = new int[n][n];

        for(int i = 0 ; i < n ; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j < n; j++) {
                map[i][j]= Integer.parseInt(input[j]);
//                visited[i][j] = true;
                if(map[i][j] == 0) continue;
                dir.add(new int[]{i,j,map[i][j], 0 });
            }
        }//input end

        input = buffer.readLine().split(" ");

        int time = Integer.parseInt(input[0]);
        int x = Integer.parseInt(input[1]);
        int y = Integer.parseInt(input[2]);

        bfs(time);
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(map[x-1][y-1]);

    }

    public static void bfs(int t){
        int size = dir.size();
        int time = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[3] == o2[3]) return o1[2] - o2[2];
                else return o1[3] - o2[3];
            }
        });


        for(int i = 0; i<size; i++){
            queue.add(dir.get(i));
        }
        while(time < t){
            size = queue.size();
            for(int i = 0 ; i < size; i++) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];

                for (int d = 0; d < 4; d++) {
                    int nx = cx + dx[d];
                    int ny = cy + dy[d];
                    if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] == 0 ) {
                        visited[nx][ny] = true;
//                        if(nx == 0 && ny ==3) System.out.println("cx = " + cur[0]+ ", cy = " + cur[1]);
                        map[nx][ny] = cur[2];
                        queue.add(new int[]{nx,ny,map[nx][ny], time+1});
                    }
                }
            }

            time++;
        }// queue while end
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y>= 0 && x < n && y < n;
    }
}


