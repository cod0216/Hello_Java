import java.io.*;
import java.util.*;

public class Main {

    private static boolean colFlip = false;
    private static boolean rowFlip = false;
    private static int turn = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buffer.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        
        int[][] board = new int[n][m];

        for (int i = 0; i < n; ++i) {
            board[i] = Arrays.stream(buffer.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] compositions = {{1, 2}, {4, 3}};
        Map<Integer, int[][]> map = new HashMap<>();
        putMapInfo(board, map, n, m);

        st = new StringTokenizer(buffer.readLine());

        while (st.hasMoreTokens()) {
            int oper = Integer.parseInt(st.nextToken());

            switch (oper) {
                case 1:
                    oper1(compositions);
                    if (turn % 2 == 0) {
                        rowFlip = !rowFlip;
                    } else {
                        colFlip = !colFlip;
                    }
                    break;

                case 2:
                    oper2(compositions);
                    if (turn % 2 == 0) {
                        colFlip = !colFlip;
                    } else {
                        rowFlip = !rowFlip;
                    }
                    break;

                case 3:
                    compositions = oper3(compositions);
                    ++turn;
                    turn %= 4;
                    break;

                case 4:
                    compositions = oper4(compositions);
                    turn = --turn + 4;
                    turn %= 4;
                    break;

                case 5:
                    compositions = oper5(compositions);
                    break;

                case 6:
                    compositions = oper6(compositions);
                    break;
            }
        }

        if (turn % 2 != 0) {
            int temp = n;
            n = m;
            m = temp;
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 2; ++j) {
                int[][] content = map.get(compositions[i][j]);

                if (rowFlip) {
                    oper1(content);
                }

                if (colFlip) {
                    oper2(content);
                }

                if (turn > 0) {
                    for (int k = 0; k < turn; ++k) {
                        content = oper3(content);
                    }
                }

                if (i == 0 && j == 0) {
                    for (int a = 0; a < n / 2; ++a) {
                        for (int b = 0; b < m / 2; ++b) {
                            result[a][b] = content[a][b];
                        }
                    }
                    continue;
                }

                if (i == 0) {
                    for (int a = 0; a < n / 2; ++a) {
                        for (int b = m / 2; b < m; ++b) {
                            result[a][b] = content[a][b - (m / 2)];
                        }
                    }
                    continue;
                }

                if (j == 1) {
                    for (int a = n / 2; a < n; ++a) {
                        for (int b = m / 2; b < m; ++b) {
                            result[a][b] = content[a - (n / 2)][b - (m / 2)];
                        }
                    }
                    continue;
                }

                for (int a = n / 2; a < n; ++a) {
                    for (int b = 0; b < m / 2; ++b) {
                        result[a][b] = content[a - (n / 2)][b];
                    }
                }
            }
        }


        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    private static void oper1(int[][] arr) {
        // 1 2
        // 4 3
        int n = arr.length;
        int half_n = arr.length / 2;
        int m = arr[0].length;
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < half_n; ++i) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }

    private static void oper2(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int half_m = m / 2;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < half_m; ++j) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][m - 1 - j];
                arr[i][m - 1 - j] = temp;
            }
        }
    }

    private static int[][] oper3(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[i][j] = arr[n - 1 - j][i];
            }
        }
        return result;
    }

    private static int[][] oper4(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                result[i][j] = arr[j][m - 1 - i];
            }
        }

        return result;
    }

    private static int[][] oper5(int[][] compositions) {
        int[][] result = new int[2][2];

        result[0][0] = compositions[1][0];
        result[0][1] = compositions[0][0];
        result[1][1] = compositions[0][1];
        result[1][0] = compositions[1][1];

        return result;
    }

    private static int[][] oper6(int[][] compositions) {
        int[][] result = new int[2][2];

        result[0][0] = compositions[0][1];
        result[0][1] = compositions[1][1];
        result[1][1] = compositions[1][0];
        result[1][0] = compositions[0][0];

        return result;
    }

    private static void putMapInfo(int[][] board, Map<Integer, int[][]> map,
                                   int n, int m) {
        int half_n = n / 2;
        int half_m = m / 2;

        int[][] one = new int[half_n][half_m];
        for (int i = 0; i < half_n; ++i) {
            for (int j = 0; j < half_m; ++j) {
                one[i][j] = board[i][j];
            }
        }
        map.put(1, one);

        int[][] two = new int[half_n][half_m];
        for (int i = 0; i < half_n; ++i) {
            for (int j = half_m; j < m; ++j) {
                two[i][j - half_m] = board[i][j];
            }
        }
        map.put(2, two);

        int[][] three = new int[half_n][half_m];
        for (int i = half_n; i < n; ++i) {
            for (int j = half_m; j < m; ++j) {
                three[i - half_n][j - half_m] = board[i][j];
            }
        }
        map.put(3, three);

        int[][] four = new int[half_n][half_m];
        for (int i = half_n; i < n; ++i) {
            for (int j = 0; j < half_m; ++j) {
                four[i - half_n][j] = board[i][j];
            }
        }
        map.put(4, four);
    }
}