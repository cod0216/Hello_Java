package TIL;

import java.io.*;
import java.util.ArrayList;

public class S1767_1 {

    static int[][] map;

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int n;
    static int cnt;
    static int chip;
    static int line;


    static ArrayList<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while (T > t) {
            n = Integer.parseInt(buffer.readLine());
            map = new int[n][n];
            list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] input = buffer.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    if (map[i][j] == 1) {
                        if (i > 0 && i < n - 1 && j > 0 && j < n - 1) {
                            list.add(new int[]{i, j});
                        }
                    }
                }
            }
            chip = 0;
            line = 12 * 12;

            DFS(0, 0, 0);

            t++;
            System.out.println("#" + t + " " + line);

        }

    }

    public static void DFS(int index, int c, int l) {
        if (index == list.size()) {
            if (chip == c) {
                if (l < line) line = l;
            } else if (c > chip) {
                chip = c;
                line = l;
            }
            return;
        }
        for(int i = 0;i< 4;i++) {
        if (check(i, list.get(index))) {
            fill(i, list.get(index), 2);
            DFS(index + 1, c + 1, l + cnt);
            fill(i, list.get(index), 0);
        }

    }


    DFS(index +1, c, l);

}

    public static boolean check(int d, int[] xy) {
        int x = xy[0];
        int y = xy[1];

        int nx = x + dx[d];
        int ny = y + dy[d];

        while (isIn(nx, ny)) {
            if (map[nx][ny] != 0) return false;
            nx += dx[d];
            ny += dy[d];
        }
        return true;
    }

    public static void fill(int d, int[] xy, int value) {
        cnt = 0;
        int x = xy[0];
        int y = xy[1];

        int nx = x + dx[d];
        int ny = y + dy[d];

        while (isIn(nx, ny)) {
            map[nx][ny] = value;
            nx += dx[d];
            ny += dy[d];
            cnt++;
        }
    }

    public static boolean isIn(int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) return true;
        return false;
    }
}
