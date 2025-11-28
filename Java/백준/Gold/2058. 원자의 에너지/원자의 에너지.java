import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = 1_000_000;

    static int N, M;
    static int[] E;
    static int[][] dp;
    static boolean[] state, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        state = new boolean[MAX + 1];

        int start = 0;
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(buffer.readLine());
            state[v] = true;
            if (i == 0) start = v;
        }

        E = new int[M];
        for (int i = 0; i < M; i++) {
            E[i] = Integer.parseInt(buffer.readLine());
        }

        visited = new boolean[MAX + 1];
        dp = new int[MAX + 1][2];

        dfs(start);
        System.out.println(Math.max(dp[start][0], dp[start][1]));
    }

    public static void dfs(int cur) {
        visited[cur] = true;
        dp[cur][0] = 0;
        dp[cur][1] = cur;

        for (int i = 0; i < M; i++) {
            int plus = cur + E[i];
            int minus = cur - E[i];

            if (plus > 0 && plus <= MAX && state[plus] && !visited[plus]) {
                dfs(plus);
                dp[cur][1] += dp[plus][0];
                dp[cur][0] += Math.max(dp[plus][0], dp[plus][1]);
            }

            if (minus > 0 && minus <= MAX && state[minus] && !visited[minus]) {
                dfs(minus);
                dp[cur][1] += dp[minus][0];
                dp[cur][0] += Math.max(dp[minus][0], dp[minus][1]);
            }
        }
    }
}
