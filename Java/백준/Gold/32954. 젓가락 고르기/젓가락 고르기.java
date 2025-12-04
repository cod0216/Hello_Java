import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static long K;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Long.parseLong(input[1]);

        long total = 0L; long pairs = 0L;

        input = buffer.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            long a = Long.parseLong(input[i]);
            total += a / 2;
            pairs += (a - 1) / 2;
        }

        if (K == 0) {
            System.out.println(0);
            return;
        }

        if (K > total) {
            System.out.println(-1);
            return;
        }

        long P = K - 1;

        long max;
        if (P <= pairs) {
            max = (long) N + 2L * P;
        } else {
            max = (long) N + pairs + P;
        }

        long ans = max + 1;
        System.out.println(ans);
    }
}
