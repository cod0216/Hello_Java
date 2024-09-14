package TIL;

import java.io.*;

/*
지구 온난화 어쩌고 저쩌고 해서 빙산이 녹는다.
2차원 배열에 정보 표시
빙산 각 부분별 높이 배열에 저장 양수로 저장됨
빙산 이외의 바다에 해당되는 칸에는 0이 저장됨(빈칸)

바다물 (사방위)주변엔 빨리 줄어듦
0이 붙은 개수만큼 1년동안 줄어듦 0보단 더 줄어들지 않음

몇년후 두덩어리 이상으로 분리되는 최초 시간 언제인지 구하라
다 녹아도 덩어리 안생기면 0출력

NM은 300이하
빙산 0~10이하
배열 첫 마지막은 0(힌트인듯)

사방위 while돌리고 그 안에서 탐색 해서 덩이리 생기면 cnt 해주면 될듯

 */
public class J2573 {
    static int R, C, ans, cnt;
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static int[][] map;
    static boolean[][] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        map = new int[R][C];


        for (int i = 0; i < R; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        while (!flag) {
            warming();
            search();
        }
        System.out.println(ans);


    }

    private static void search() {
        cnt = 0;
        visited = new boolean[R][C];
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] != 0 && !visited[x][y]) {
                    cnt++;
                    visited[x][y] = true;
                    DFS(x, y);
                }
            }
        }
        if (cnt > 1) flag = true;
        else if (cnt == 0) {
            flag = true;
            ans = 0;
        }
    }

    private static void DFS(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] > 0) {
                visited[nx][ny] = true;
                DFS(nx, ny);
            }
        }
    }

    private static void warming() {
        int[][] tempMap = new int[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (map[x][y] > 0) {
                    int seaCount = 0;
                    for (int d = 0; d < 4; d++) {
                        int nx = x + dx[d];
                        int ny = y + dy[d];
                        if (isIn(nx, ny) && map[nx][ny] == 0){
                            seaCount++;
                        }
                    }
                    tempMap[x][y] = Math.max(0, map[x][y] - seaCount);
                }
            }
        }
        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                map[x][y] = tempMap[x][y];
            }
        }
        ans++;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < R && y < C;
    }
}
