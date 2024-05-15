package TIL;

import java.io.*;
import java.util.*;

public class JS1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        for (int k = 0; k < T; k++) {
            int num = Integer.parseInt(buffer.readLine());
            int result = 0;
            int[] build = new int[num + 4];

            String[] input = buffer.readLine().split(" ");

            for (int i = 0; i < num; i++) {
                build[i + 2] = Integer.parseInt(input[i]);
            }


            for (int i = 2; i < build.length - 2; i++) {
                int right = Math.max(build[i + 2], build[i + 1]);
                int left = Math.max(build[i - 2], build[i - 1]);
                int value = Math.max(right, left);
                if (build[i] > value) result += build[i] - value;
            }
            System.out.println("#" + k + " " + result);
        }
    }
}
