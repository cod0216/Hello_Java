package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class J2459 {
    private static boolean visited[];

    private static int n, k;
    private static int[][] map;

    private int min = Integer.MAX_VALUE;
    private static LinkedList<int[]>[] dir;
    private static int[] dx = new int[]{0, -1, 0, 1};
    private static int[] dy = new int[]{1, 0, -1, 0};

    public static void main(String[] arg) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());
        map = new int[n + 1][n + 1];
        k = Integer.parseInt(buffer.readLine());
        visited = new boolean[k];
        dir = new LinkedList[n + 1];
        for (int i = 0; i <= k; i++) {
            dir[i] = new LinkedList<>();
        }

        for (int i = 1; i < k + 1; i++) {
            String[] input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            dir[i].add(new int[]{x, y});
        }

        Integer.parseInt(buffer.readLine());

        run();
    }

    private static void run() {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        while (queue.isEmpty()) {
            int cur[] = queue.poll();
            Integer cx = cur[0];
            Integer cy = cur[1];
            Integer cd = cur[2];


            // check end point
            // short length

            Integer nx = cd + cx;
            Integer ny = cd + cy;
            if (nx.equals(1) && ny.equals(2)) {
                // cut process

            }
            if (Boolean.TRUE.equals(isIn(nx, ny))) {
                for (int i = 1; i <= k; i++) {
                    int[] dot = dir[i].get(0);
                    if ((nx.equals(dot[0]) && ny.equals(dot[1]))) {
                        if (Boolean.FALSE.equals(visited[i])) {
                            visited[i] = Boolean.TRUE;
                            cd++;
                            if (cd >= 0 && cd < 4) queue.add(new int[]{nx, ny, cd});
                            cd--;
                            if (cd >= 0 && cd < 4) queue.add(new int[]{nx, ny, cd});

                        } else queue.add(new int[]{nx, ny, cd});
                    }
                }
            }
        }
    }
    // 길이 표시는 어떻게 할 것인가

    private static boolean isIn(int x, int y) {
        return x >= 1 && y >= 1 && x <= n && y <= n;
    }
}
