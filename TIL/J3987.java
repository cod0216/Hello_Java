package TIL;

import java.io.*;
import java.util.StringTokenizer;

/*
보이저 1호는 1977년 에 발사된 NASA의 태양계 무인 탐사선이다.
현재 보이저 1호는 태양권 덮개(헬리오시스)에 있다.

보이저 1호와 같이 오랜 기간동안 활동하는 탐사선은 경로를 항성계를 만날 때 마다 라디오 시그널 메시지를 이용해서 기록한다.

항성계를 N x M개의 직사각형으로 나누어짐
각 칸은 행성, 블랙홀 포함 가능
비어 있을 수 있음

탐사선은 인접한 네칸중 하나 골라서 시그널 보낸다.

시그널은 항상 일직선으로 전파,
행성을 만났을 경우에는 전파되는 방향이 90도로 바뀌게 된다.
행성은 / \로 표현되는 두 종류 있음 반사됨
시그널은 블랙홀이나 항성계를 벗어날 때까지 ㄱ속 전파됨

시그널이 인접한 칸으로 이동하는데 걸리는 시간은 1초
 */
public class J3987 {

    static int N, M, X, Y, max;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static char[][] map;
    static char dirC;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String str = buffer.readLine();
            map[i] = str.toCharArray();
        }

        input = buffer.readLine().split(" ");

        X = Integer.parseInt(input[0]) - 1;
        Y = Integer.parseInt(input[1]) - 1;


        for (int d = 0; d < 4; d++) {
            int time = signal(d);
            if (time > max) {
                max = time;
                dirC = toChar(d);
            }
        }
        System.out.println(dirC);
        System.out.println((max == Integer.MAX_VALUE ? "Voyager" : max));
    }

    public static int signal(int d) {
        boolean[][][] visited = new boolean[N][M][4];
        int time = 1;
        int nx = X;
        int ny = Y;

        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (!canGo(nx, ny)) break;
            if (visited[nx][ny][d]) return Integer.MAX_VALUE;
            visited[nx][ny][d] = true;

            switch (map[nx][ny]) {
                case '.':
                    break;
                case '\\':
                    d = (d == 0) ? 3 : (d == 1) ? 2 : (d == 2) ? 1 : 0;
                    break;
                case '/':
                    d = (d == 0) ? 1 : (d == 1) ? 0 : (d == 2) ? 3 : 2;
                    break;
                case 'C':
                    return time;
            }

            time++;
        }

        return time;
    }

    private static char toChar(int init) {
        switch (init) {
            case 0:
                return 'U';
            case 1:
                return 'R';
            case 2:
                return 'D';
            default:
                return 'L';
        }
    }

    public static boolean canGo(int x, int y) {
        if (x < N && y < M && x >= 0 && y >= 0 && map[x][y] != 'C') return true;
        return false;
    }
}
