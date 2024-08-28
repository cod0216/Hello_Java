package TIL;

import java.util.*;
import java.io.*;
/*
 *
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2
 */

public class S1861 {
    static int[] dx = new int[] {0, 1, 0, -1};
    static int[] dy = new int[] {1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int max;
    static ArrayList<Integer> A;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t) {
            n = Integer.parseInt(buffer.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            A = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                String[] input = buffer.readLine().split(" ");
                for(int j = 0 ; j< n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            max = 0;
            for(int i = 0 ; i < n; i++) {
                for(int j = 0 ; j < n; j++) {
                    find(i,j, i,j ,1);
                }
            }


            Collections.sort(A);
            t++;
            System.out.println("#" + t + " " + A.get(0) + " "+ max);
        }
    }

    public static void find(int baseX, int baseY, int x, int y, int depth) {
        boolean toggle = false;


        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && ny>=0 && nx<n && ny< n && !visited[nx][ny] && (map[x][y]+1 == map[nx][ny])) {
                visited[nx][ny] = true;
                toggle = true;
                find(baseX, baseY, nx, ny, depth+1);
                visited[nx][ny] = false;
            }
        }
        if(!toggle) {
            if(depth > max) {
                A.clear();
                max = depth;
                A.add(map[baseX][baseY]);
            }
            else if(depth == max) {
                A.add(map[baseX][baseY]);
            }

        }


    }

}


