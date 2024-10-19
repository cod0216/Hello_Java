package TIL;

import java.util.*;
import java.io.*;

public class J17244 {
    static int[] dx = new int[] { 1, 0, -1, 0 };
    static int[] dy = new int[] { 0, -1, 0, 1 };
    static int m, n, keyCount;
    static boolean[][][] visited;
    static char[][] map;
    static List<int[]> items = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new char[n][m];
        visited = new boolean[n][m][1<<5];
        int x = 0; int y = 0;



        for(int i =0; i <n; i++) {
            input = buffer.readLine().split("");
            for(int j =0; j <m; j++) {
                map[i][j] = input[j].charAt(0);
                if(map[i][j] == 'S') {
                    x = i; y =j;
                }
                if(map[i][j] == 'X') {
                    items.add(new int[] { i, j, keyCount++ });
                }
            }
        }

        int ans = bfs(x, y);

        System.out.println(ans);
    }

    public static int bfs(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { a, b, 0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int depth = cur[2];
            int key = cur[3];

            if(map[x][y] == 'E' && key==((1 << keyCount)-1) ) return depth;
            if(visited[x][y][key]) continue;
            visited[x][y][key]= true;


            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(isIn(nx, ny)&& !visited[nx][ny][key]) {
                    if(map[nx][ny]=='.' || map[nx][ny]=='S' || map[nx][ny]=='E') {
                        queue.offer(new int[] {nx,ny, depth+1, key});
                    }
                    if(map[nx][ny]=='X') {
                        int newKey = key;
                        for (int[] item : items) {
                            if (item[0] == nx && item[1] == ny) {
                                newKey = key | (1 << item[2]);
                                break;
                            }
                        }
                        queue.offer(new int[] { nx, ny, depth + 1, newKey });
                    }
                }
            }

        } // queue while end

        return -1;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}