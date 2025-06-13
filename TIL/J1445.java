package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Sunday implements Comparable<Sunday> {
    int x, y, g, r;

    public Sunday(int x, int y, int g, int r) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.r = r;
    }

    @Override
    public int compareTo(Sunday o) {
        if(this.g == o.g) return this.r - o.r;
        return this.g - o.g;
    }

}
public class J1445 {
    private static int  n, m,
                        startX, startY,
                        endX, endY,
                        ansG, ansR;
    private static boolean[][] visited;
    private static char[][] map;
    private static int[] dx = new int[]{0,1,0,-1};
    private static int[] dy = new int[]{1,0,-1,0};



    private static void init() throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        map = new char[n][m];

        visited = new boolean[n][m];

        for(int i = 0; i< n; i++){
            map[i]=buffer.readLine().toCharArray();
            for(int j = 0; j<m; j++){
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                } else if(map[i][j] == 'F') {
                    endX = i;
                    endY = j;
                }
            }
        }
    }

    public static boolean checkInline(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    public static void searchRound(){
        for(int i = 0; i< n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'g'){
                    for(int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];
                        if (checkInline(nx, ny) && map[nx][ny] == '.') {
                            map[nx][ny] = 'a';
                        }
                    }
                }
            }
        }
    }

    public static void bfs(int x, int y) {
        PriorityQueue<Sunday> pq = new PriorityQueue<>();
        pq.add(new Sunday(x, y, 0, 0));
        visited[x][y] = true;

        while(!pq.isEmpty()) {
            Sunday cur = pq.poll();
            int cx = cur.x;
            int cy = cur.y;
            int cg = cur.g;
            int cr = cur.r;

            if(cx == endX && cy == endY) {
                ansG = cg;
                ansR = cr;
                return;
            }

            for(int i=0; i<4; ++i) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(checkInline(nx,ny) && !visited[nx][ny]) {

                    int ng, nr;
                    if (map[nx][ny] == 'g') {
                        ng = cg + 1;
                        nr = cr;
                    } else if (map[nx][ny] == 'a') {
                        ng = cg;
                        nr = cr + 1;
                    } else {
                        ng = cg;
                        nr = cr;
                    }

                    visited[nx][ny] = true;
                    pq.add(new Sunday(ny, nx, ng, nr));
                }
            }
        } // pq while end
    }
    public static void main(String[] args) throws IOException {
        init();
        searchRound();
        bfs(startX, startY);
        System.out.println(ansG + " " + ansR);
    }
}
