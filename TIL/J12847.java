package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = buffer.readLine().split(" ");
        int[] arr = new int[N];

        long max = 0;
        int value = 0;

        for (int i = 0; i < N; i++) {
            value = Integer.parseInt(input[i]);
            arr[i] = value;
        }

        long v = 0;
        for (int i = 0; i <M ; i++) {
            v += arr[i];
        }
        max = v;
        for (int i = M; i < N; i++) {
            v = v - arr[i-M] + arr[i];
            max = Math.max(max,v);
        }

        System.out.println(max);
    }
}
