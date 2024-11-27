import java.io.*;
import java.util.*;

public class Solution {

    static int N;
    static int[][] map, dist;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dist = new int[N][N];

            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            int result = bfs();
            sb.append("#").append(tc).append(" ").append(result).append("\n");

        }

        System.out.println(sb);


        br.close();
    }

    public static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0}); // 초기값 (0, 0)
        dist[0][0] = 0; // dist초기값

        while(!queue.isEmpty()) {

            int[] res = queue.poll();
            int x = res[0];
            int y = res[1];

            for(int i=0; i<4; i++) {

                int nx = x + dx[i];
                int ny = y + dy[i];

                if(!isIn(nx, ny)) continue;

                int fuel = dist[x][y] + needFuel(x, y, nx, ny);
                if(dist[nx][ny] > fuel) {
                    dist[nx][ny] = fuel;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        return dist[N-1][N-1];
    }

    public static boolean isIn(int x, int y) {
        if(x>=0 && y>=0 && x<N && y<N) {
            return true;
        }
        return false;
    }

    public static int needFuel(int x, int y, int nx, int ny) {
        if(map[x][y] == map[nx][ny]) {
            return 1;
        } else if(map[x][y] > map[nx][ny]) {
            return 0;
        } else {
            return (map[nx][ny] - map[x][y]) * 2;
        }
    }
}