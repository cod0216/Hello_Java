package TIL;


import java.io.*;


/*
유현이가 새집으로 이사함
크기 NxN 집인데 1x1크기의 정사각형 칸으로 나누어져 있고 각 칸은 (r,c)로 나타낼 수 있다.
여기서 r은 행의 번호, c는 열의 번호이고, 행과 열의 번호는 1부터 시작한다.
각각의 칸은 빈 칸이거나 벽이다.

\


 */
public class J17070 {
    static int[][] map;
    static int res, N;
    static int[] dx = new int[]{0, 1, 1};
    static int[] dy = new int[]{1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        map = new int[N][N];
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        res = 0;
        pipeConnect(0, 0, 0);

        System.out.println(res);

    }

    public static void pipeConnect(int x, int y, int direction) {
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (isIn(nx, ny)) {
            if (direction == 1) {
                if ((map[nx - 1][ny] == 1)
                        || (map[nx][ny - 1] == 1)) return;
            }

            if (nx == N - 1 && ny == N - 1) {
                res++;
                return;
            }

            if (direction == 0) {
                pipeConnect(nx, ny, direction);
                pipeConnect(nx, ny, direction + 1);
            } else if (direction == 1) {
                pipeConnect(nx, ny, direction - 1);
                pipeConnect(nx, ny, direction);
                pipeConnect(nx, ny, direction + 1);
            } else if (direction == 2) {
                pipeConnect(nx, ny, direction - 1);
                pipeConnect(nx, ny, direction);
            }
        }
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N && map[x][y] == 0;
    }
}
