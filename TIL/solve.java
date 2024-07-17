package TIL;

import java.io.*;
import java.util.*;

    public class solve {

        static int[] dx = {0, 1, 0, -1};
        static int[] dy = {1, 0, -1, 0};

        public static void main(String[] args) throws IOException {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(buffer.readLine());

            for (int t = 1; t <= T; t++) {
                String[] input = buffer.readLine().split(" ");

                int N = Integer.parseInt(input[0]);
                int startX = Integer.parseInt(input[1]);
                int startY = Integer.parseInt(input[2]);
                int numJumper = Integer.parseInt(input[3]);

                int[][] jumpers = new int[numJumper][2];
                int index = 0;
                input = buffer.readLine().split(" ");
                for (int i = 0; i < numJumper; i++) {

                    jumpers[i][0] = Integer.parseInt(input[index++]) - 1;
                    jumpers[i][1] = Integer.parseInt(input[index++]) - 1;
                }

                int numMoves = Integer.parseInt(buffer.readLine());
                int x = startX;
                int y = startY;
                input = buffer.readLine().split(" ");
                index = 0;
                for (int i = 0; i < numMoves; i++) {
                    int direction = Integer.parseInt(input[index++]) - 1;
                    int steps = Integer.parseInt(input[index++]);

                    for (int j = 0; j < steps; j++) {
                        x += dx[direction];
                        y += dy[direction];

                        if (x < 0 || x >= N || y < 0 || y >= N) {
                            x = 0;
                            y = 0;
                            break;
                        }

                        for (int k = 0; k < numJumper; k++) {
                            if (x == jumpers[k][0] && y == jumpers[k][1]) {
                                x = 0;
                                y = 0;
                                break;
                            }
                        }
                    }
                }

                System.out.printf("#%d %d %d\n", t, x + 1, y + 1);
            }
        }
    }

