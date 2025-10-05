package TIL;

import java.util.*;
import java.io.*;

public class J17779_2 {
    static int N, totalPeople, res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(buffer.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                totalPeople += map[i][j];
            }
        }

        res = Integer.MAX_VALUE;

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                for (int d1 = 1; d1 < N; d1++) {
                    for (int d2 = 1; d2 < N; d2++) {
                        if (isIn(x + d1 + d2, y - d1) && isIn(x + d1 + d2, y + d2)) {
                            elec(x, y, d1, d2);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }

    public static void elec(int x, int y, int d1, int d2) {
        boolean[][] border = new boolean[N][N];

        for (int i = 0; i <= d1; i++) {
            border[x + i][y - i] = true;
            border[x + d2 + i][y + d2 - i] = true;
        }

        for (int i = 0; i <= d2; i++) {
            border[x + i][y + i] = true;
            border[x + d1 + i][y - d1 + i] = true;
        }

        int[] peopleSum = new int[5];

        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j])
                    break;
                peopleSum[0] += map[i][j];
            }
        }

        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j])
                    break;
                peopleSum[1] += map[i][j];
            }
        }

        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j])
                    break;
                peopleSum[2] += map[i][j];
            }
        }

        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j])
                    break;
                peopleSum[3] += map[i][j];
            }
        }

        peopleSum[4] = totalPeople;

        for (int i = 0; i < 4; i++) {
            peopleSum[4] -= peopleSum[i];
        }

        Arrays.sort(peopleSum);

        res = Math.min(res, peopleSum[4] - peopleSum[0]);
    }

}

