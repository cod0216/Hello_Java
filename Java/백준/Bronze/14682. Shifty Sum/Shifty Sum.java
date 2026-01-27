import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine().trim());
        int k = Integer.parseInt(br.readLine().trim());

        long sum = 0;
        long cur = n;
        for (int i = 0; i <= k; i++) {
            sum += cur;
            cur *= 10;
        }

        System.out.print(sum);
    }
}
