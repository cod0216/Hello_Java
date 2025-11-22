import java.util.*;
import java.io.*;

public class Main {
    static int ORIGIN, N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);

        ORIGIN = 1 << n;
        N = ORIGIN;
        M = ORIGIN;

        map = new int[ORIGIN][ORIGIN];

        for (int i = 0; i < ORIGIN; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < ORIGIN; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for (int i = 0; i < R; i++) {
            input = buffer.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            int l = Integer.parseInt(input[1]);

            excute(k, l);
        }

        for (int i = 0; i < ORIGIN; i++) {
            for (int j = 0; j < ORIGIN; j++) {
                sb.append(map[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void excute(int k, int l) {
        int len = 1 << l;
        int size = ORIGIN;

        int[][] tmp = new int[size][size];

        for (int y = 0; y < size; y += len) {
            for (int x = 0; x < size; x += len) {

                for (int i = 0; i < len; i++) {
                    for (int j = 0; j < len; j++) {
                        int ny = y;
                        int nx = x;

                        switch (k) {
                            case 1:
                                ny = y + (len - 1 - i);
                                nx = x + j;
                                break;
                            case 2:
                                ny = y + i;
                                nx = x + (len - 1 - j);
                                break;
                            case 3:
                                ny = y + j;
                                nx = x + (len - 1 - i);
                                break;
                            case 4:
                                ny = y + (len - 1 - j);
                                nx = x + i;
                                break;
                            case 5:
                                ny = (size - len) - y + i;
                                nx = x + j;
                                break;
                            case 6:
                                ny = y + i;
                                nx = (size - len) - x + j;
                                break;
                            case 7:
                                ny = x + i;
                                nx = (size - len) - y + j;
                                break;
                            case 8:
                                ny = (size - len) - x + i;
                                nx = y + j;
                                break;
                        }

                        tmp[ny][nx] = map[y + i][x + j];
                    }
                }
            }
        }

        map = tmp;
    }
}
