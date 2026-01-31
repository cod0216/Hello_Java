import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(buffer.readLine());
        long[] H = new long[N + 1];

        String[] parts = buffer.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            H[i] = Long.parseLong(parts[i]);
        }
        H[N] = 0;

        int[] stack = new int[N + 1];
        int top = -1;

        long ans = 0;

        for (int i = 0; i <= N; i++) {
            long current = H[i];

            while (top >= 0 && H[stack[top]] > current) {
                int idx = stack[top--];
                long height = H[idx];

                int leftIndex = (top >= 0) ? stack[top] : -1;
                long width = i - leftIndex - 1;

                long side = Math.min(height, width);
                if (side > ans) {
                    ans = side;
                }
            }

            stack[++top] = i;
        }

        System.out.println(ans);
    }
}
