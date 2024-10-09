package TIL;

import java.io.*;

public class J12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] items = new int[n + 1][2];

        for (int i = 1; i <= n; i++) {
            input = buffer.readLine().split(" ");
            items[i][0] = Integer.parseInt(input[0]);
            items[i][1] = Integer.parseInt(input[1]);
        }

        int[][] dp = new int[n + 1][m + 1];

        for (int k = 1; k <= m; k++) {
            for (int i = 1; i <= n; i++) {
                dp[i][k] = dp[i-1][k];
                if (k - items[i][0] >= 0) {
                    dp[i][k] = Math.max(dp[i - 1][k], items[i][1] + dp[i - 1][k - items[i][0]]);
                }
            }
        }

        System.out.println(dp[n][m]);

    }

}

