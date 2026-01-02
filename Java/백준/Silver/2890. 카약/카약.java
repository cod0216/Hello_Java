import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int[] range = new int[10];
        int max = 0;

        for (int i = 0; i < a; i++) {
            String line = buffer.readLine();
            for (int j = b - 2; j >= 1; j--) {
                char ch = line.charAt(j);
                if ('1' <= ch && ch <= '9') {
                    int team = ch - '0';
                    range[team] = j;
                    max = Math.max(max, j);
                    break;
                }
            }
        }

        int[] race = new int[10];
        int score = 1;

        while (max >= 1) {
            boolean good = false;
            for (int team = 1; team <= 9; team++) {
                if (range[team] == max) {
                    race[team] = score;
                    good = true;
                }
            }
            if (good) score++;
            max--;
        }

        for (int team = 1; team <= 9; team++) {
            System.out.println(race[team]);
        }
    }
}
