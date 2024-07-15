package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s2008_3 {

    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] build;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int n = 0;
        while (T > n) {
            N = Integer.parseInt(buffer.readLine());

            build = new char[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = buffer.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    build[i][j] = input[j].charAt(0);
                }
            }

            int max = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (build[i][j] == 'B') {
                        int hight = 0;
                        boolean check = false;

                        for (int k = 0; k < 8; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (build[nx][ny] == 'G') {
                                    hight = 2;
                                    check = true;
                                    break;
                                }
                            }
                        }

                        if (!check) {
                            int rowCnt = cntInRow(i);
                            int colCnt = cntInCol(j);
                            hight = rowCnt + colCnt - 1;
                        }

                        if (max < hight) {
                            max = hight;
                        }
                    }
                }
            }

            System.out.println(max);
            n++;
        }

    }

    public static int cntInRow(int row) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (build[row][i] == 'B') {
                cnt++;
            }
        }
        return cnt;
    }

    public static int cntInCol(int col) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (build[i][col] == 'B') {
                cnt++;
            }
        }
        return cnt;
    }
}

