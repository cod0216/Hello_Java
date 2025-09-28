package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class J1012 {
    static int N, M;
    static int dx[] = new int[]{1,0,-1,0};
    static int dy[] = new int[]{0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){
            String[] input = buffer.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            int[][] map = new int[N][M];

            for(int i = 0; i < K; i++){
                input = buffer.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                map[x][y] = 1;
            }
            int cnt = 0;

            for (int i = 0; i <N; i++) {
                for (int j = 0; j <M; j++) {
                    if(map[i][j] != 2 && map[i][j] != 0) {
                        dfs(map, i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
            t++;
        }
    }

    public static void dfs(int[][] map, int x, int y){
        if(map[x][y] == 0 || map[x][y] == 2) return;

        map[x][y] = 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(isIn(nx,ny)) dfs(map,nx, ny);
        }
    }

    public static boolean isIn(int x, int y){
        return x >=0 && y >= 0 && x < N && y < M;
    }

    public static class J1707_5 {
        static int T;
        static LinkedList<Integer>[] list;
        static boolean[] visited, isBlue;
        public static void main(String[] args) throws IOException {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            T = Integer.parseInt(buffer.readLine());
            int t = 0;

            while(T>t){
                String[] input = buffer.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                int m = Integer.parseInt(input[1]);
                list = new LinkedList[n+1];
                visited = new boolean[n+1];
                isBlue = new boolean[n+1];

                for (int i = 0; i <= n; i++) {
                    list[i] = new LinkedList<>();
                }

                for(int i = 0 ; i < m; i++){
                    input = buffer.readLine().split(" ");
                    int start = Integer.parseInt(input[0]);
                    int end = Integer.parseInt(input[1]);

                    list[start].add(end);
                    list[end].add(start);
                }
                boolean ans = false;
                for(int i = 1 ; i <= n; i++){
                    if(visited[i]) continue;
                    ans = inspect(i, new boolean[n+1]);
                    if(!ans) break;
                }

                if(ans) System.out.println("YES");
                else System.out.println("NO");
                t++;
            }
        }

        public static boolean inspect(int start, boolean[] color){
            Queue<Integer> queue = new LinkedList<>();
            visited[start] = true;
            isBlue[start] = true;
            queue.offer(start);

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int now : list[cur]){
                    if(visited[now]){
                        if(isBlue[cur] == isBlue[now]) return false;
                        else continue;
                    }
                    visited[now] = true;
                    isBlue[now] = !isBlue[cur];
                    queue.offer(now);
                }
            }
            return true;
        }
    }
}
