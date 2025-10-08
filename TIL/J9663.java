package TIL;

import java.util.*;
import java.io.*;


public class J9663 {
    static int N, ans;
    static int[] dx = new int[]{1, 1, -1, -1, 1, 0, -1, 0};
    static int[] dy = new int[]{1, -1, 1, -1, 0, -1, 0, 1};
    static boolean[][] visited;
    static boolean[] col, dl, dr;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(buffer.readLine());
        visited = new boolean[N][N];

        col = new boolean[N];
        dl = new boolean[N * 2 -1];
        dr = new boolean[N * 2 -1];

        for(int i = 0; i < N; i++){
            dfs(0,i);
        }

        System.out.println(ans);
    }

    public static void dfs(int r, int c){

        if(!isIn(r,c)) return;
        int d1 = r + c;
        int d2 = r - c + (N - 1);

        if(col[c] || dr[d1] || dl[d2]) return;

        col[c] = dr[d1] = dl[d2] = true;

        if(r == N - 1){
            ans++;
            col[c] = dr[d1] = dl[d2] = false;
            return;
        }

        int nr = r + 1;
        for(int nc = 0 ; nc < N; nc++){
            dfs(nr, nc);
        }
        col[c] = dr[d1] = dl[d2] = false;
    }

    public static int[][] process(int x, int y, int[][] map){
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[N][N];

        for(int d = 0; d < 8; d++){
            queue.offer(new int[]{x, y, d});
        }

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            int cx = cur[0];
            int cy = cur[1];
            int d = cur[2];

            int nx = cx + dx[d];
            int ny = cy + dy[d];

            if(!isIn(nx,ny)) continue;
            if(check[nx][ny]) continue;

            check[nx][ny] = true;
            map[nx][ny] = 1;
            queue.offer(new int[]{nx, ny, d});
        }

        return map;
    }
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}

