import java.io.*;
import java.util.*;

public class Main {
    static final long LIMIT = 5_000_000L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int T = Integer.parseInt(br.readLine().trim());

        for (int tc = 0; tc < T; tc++) {
            ArrayList<Integer> prices = new ArrayList<>();
            while (true) {
                String line = br.readLine();
                if (line == null) return;
                int v = Integer.parseInt(line.trim());
                if (v == 0) break;
                prices.add(v);
            }

            prices.sort(Collections.reverseOrder());

            long sum = 0;
            boolean expensive = false;

            for (int i = 0; i < prices.size(); i++) {
                int price = prices.get(i);
                int exp = i + 1;

                long cap = (LIMIT - sum) / 2;
                if (cap <= 0) {
                    expensive = true;
                    break;
                }

                long pow = powCap(price, exp, cap);
                if (pow == -1) {
                    expensive = true;
                    break;
                }

                sum += (pow << 1);
                if (sum > LIMIT) {
                    expensive = true;
                    break;
                }
            }

            out.append(expensive ? "Too expensive" : Long.toString(sum)).append('\n');
        }

        System.out.print(out.toString());
    }

    static long powCap(long base, int exp, long cap) {
        if (base <= 1) {
            long val = (base == 0) ? 0L : 1L;
            return (val <= cap) ? val : -1L;
        }
        long result = 1L;
        long b = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                if (result > cap / b) return -1L;
                result *= b;
            }
            exp >>= 1;
            if (exp > 0) {
                if (b > cap / b) return -1L;
                b *= b;
            }
        }
        return result;
    }
}
