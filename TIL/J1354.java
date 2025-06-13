package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1354 {
    static long n, p, q, x, y;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Long.parseLong(input[0]);
        p = Integer.parseInt(input[1]);
        q = Integer.parseInt(input[2]);
        x = Integer.parseInt(input[3]);
        y = Integer.parseInt(input[4]);

        System.out.println(pibo(n));
    }

    public static long pibo(long num){
         if(num <= 0) return 1;
         long ans = pibo(num/p - x) + pibo(num / q - y);
         return ans;
    }
}
