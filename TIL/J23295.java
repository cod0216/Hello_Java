package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J23295 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] timeStart = new int[100001];
        int[] timeEnd = new int[100001];

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(buffer.readLine());
            for (int i = 0; i < n; i++) {
                input = buffer.readLine().split(" ");
                int from = Integer.parseInt(input[0]);
                int to = Integer.parseInt(input[1]);

                timeStart[from]++;
                timeEnd[to]++;
            }
        }

        int[] students = new int[100001];
        students[0] = timeStart[0]-timeEnd[0];

        for (int i = 1; i < 100001; i++) {
            students[i] = students[i - 1] + timeStart[i] - timeEnd[i];
        }

        int maxStudent = 0;
        int ansTime = 0;

        for (int i = 0; i <= 100000 - m; i++) {
            int sum = 0;
            for (int j = i; j < i + m; j++) {
                sum += students[j];
            }
            if (sum > maxStudent) {
                maxStudent = sum;
                ansTime = i;
            }
        }

        System.out.println(ansTime + " " + (ansTime + m));
    }
}
