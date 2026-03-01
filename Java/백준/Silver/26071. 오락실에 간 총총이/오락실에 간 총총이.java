import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE;
        int total = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char ch = line.charAt(j);
                if (ch == 'G') {
                    total++;
                    if (i < minR) minR = i;
                    if (i > maxR) maxR = i;
                    if (j < minC) minC = j;
                    if (j > maxC) maxC = j;
                }
            }
        }

        if (total <= 1) {
            System.out.println(0);
            return;
        }

        int ans;
        if (minR == maxR) {
            ans = Math.min(maxC, (N - 1) - minC);
        } else if (minC == maxC) {
            ans = Math.min(maxR, (N - 1) - minR);
        } else {
            int top = maxR;
            int bottom = (N - 1) - minR;
            int left = maxC;
            int right = (N - 1) - minC;

            ans = Math.min(
                    Math.min(top + left, top + right),
                    Math.min(bottom + left, bottom + right)
            );
        }

        System.out.println(ans);
    }
}