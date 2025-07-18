package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J14465 {
    static int N,K,B;
    static boolean broken[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        B = Integer.parseInt(input[2]);

        broken = new boolean[N+1];
        int value=0;

        for (int i = 0; i <B; i++) {
           int idx  = Integer.parseInt(buffer.readLine());
            broken[idx] = true;
        }

        for (int i = 0; i <=K; i++) {
            if(broken[i]) value++;
        }

        int min = value;

        for (int i = 1; i <= N - K; i++) {
            if(broken[i]) value--;
            if(broken[i + K]) value++;

            min = Math.min(min,value);
        }
        System.out.println(min);
    }


}
