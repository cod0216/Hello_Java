package TIL;

import java.io.*;
import java.util.*;

public class J6987 {
    static int[][] play;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        int T = 4;
        int t = 0;
        while (T > t) {
            play = new int[6][3];
            String[] input = buffer.readLine().split(" ");
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    play[i][j] = Integer.parseInt(input[(3*i)+j]);
                }
            }
            n=0;
            game(0, 0, 1, new int[6][3]);

            System.out.print(n + " ");
            t++;
        }

    }

    public static void game(int r, int team, int opponent, int[][] result) {
        if (r == 15) {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 3; j++) {
                    if (play[i][j] != result[i][j]) return;
                }
            }
            n = 1;
            return;
        }

        if(opponent == 6) {
            team++;
            opponent = team+1;
        }

        if(team >= 6 || opponent>=6) return;

        result[team][0]++;
        result[opponent][2]++;
        game(r+1,  team, opponent+1, result);
        result[team][0]--;
        result[opponent][2]--;

        result[team][1]++;
        result[opponent][1]++;
        game(r+1,  team, opponent+1, result);
        result[team][1]--;
        result[opponent][1]--;

        result[team][2]++;
        result[opponent][0]++;
        game(r+1,  team, opponent+1, result);
        result[team][2]--;
        result[opponent][0]--;

    }

}
