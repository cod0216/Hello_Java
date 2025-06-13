package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J14565 {
    static long a, n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        a = Long.parseLong(input[0]);
        n = Long.parseLong(input[1]);

        System.out.print(Math.abs(n - a) + " ");


        long[] result = exGcd(n, a);
        long gcd = result[2];
        long m = result[0];

        if (gcd != 1) {
            System.out.println("-1");
        } else {

            m = (m % n + n)%n;
            System.out.println(m);
        }
    }

    public static long[] exGcd(long a, long b) {
        long x1 = 1, y1 = 0, r1 = a;
        long x2 = 0, y2 = 1, r2 = b;

        while (r2 != 0) {
            long q = r1 / r2;

            long r = r1 - q * r2;
            long x = x1 - q * x2;
            long y = y1 - q * y2;

            x1 = x2;
            y1 = y2;
            r1 = r2;

            x2 = x;
            y2 = y;
            r2 = r;
        }

        return new long[]{x1, y1, r1};
    }
}


