import java.io.*;
import java.util.*;

/*
    풀지마라
*/

public class Main {

    static int N, M;
    static int[][] map;
    static final int EMPTY = -1;

    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> queue = new ArrayDeque<>();
    static Point[] points = new Point[2];
    static int removedCount = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    static class Point {
        int x, y;

        Point() {
            x = EMPTY;
        }

        void set(int r, int c) {
            x = r;
            y = c;
        }

        void clear() {
            x = EMPTY;
        }

        boolean isEmpty() {
            return x == EMPTY;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];

        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if (map[i][j] == 0) zeroCnt++;
            }
        }

        if ((N * M) % 2 == 1 || (zeroCnt % 2 == 1)) {
            System.out.println(-1);
            return;
        }

        points[0] = new Point();
        points[1] = new Point();

        sb.append("1\n");

        boolean found = false;
        outer:
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (r + 1 < N && map[r][c] == map[r + 1][c]) {
                    removePair(r, c, r + 1, c);
                    found = true;
                    break outer;
                }
                if (c + 1 < M && map[r][c] == map[r][c + 1]) {
                    removePair(r, c, r, c + 1);
                    found = true;
                    break outer;
                }
            }
        }

        if (!found) {
            System.out.println(-1);
            return;
        }

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int r = pos / M;
            int c = pos % M;

            for (int d = 0; d < 4; d++) {
                int nr = r + dx[d];
                int nc = c + dy[d];

                if (!isIn(nr, nc)) continue;
                if (map[nr][nc] == EMPTY) continue;

                int val = map[nr][nc];
                Point p = points[val];

                if (p.isEmpty()) {
                    p.set(nr, nc);
                } else if (p.x != nr || p.y != nc) {
                    int pr = p.x;
                    int pc = p.y;
                    p.clear();

                    removePair(pr, pc, nr, nc);
                }
            }
        }

        if (removedCount == N * M) {
            System.out.print(sb);
        } else {
            System.out.println(-1);
        }
    }

    static void removePair(int r1, int c1, int r2, int c2) {
        remove(r1, c1);
        remove(r2, c2);
        sb.append((r1 + 1)).append(' ').append((c1 + 1)).append(' ')
          .append((r2 + 1)).append(' ').append((c2 + 1)).append('\n');
    }

    static void remove(int r, int c) {
        map[r][c] = EMPTY;
        queue.add(r * M + c);
        removedCount++;
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
