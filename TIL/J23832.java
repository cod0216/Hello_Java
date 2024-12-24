package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J23832 {
    public static void main(String[] args) throws IOException {


        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        long m = Long.parseLong(buffer.readLine());
        for(int n = 1; n<=m; n ++) {

            if (n == 1) {
                continue;
            }// exception

            long ans = n;
            long cnt = n;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (cnt % i == 0) {
                    ans = ans - ans / i;
                    while (cnt % i == 0) {
                        cnt = cnt / i;
                    }
                }
            }

            if (cnt > 1) {
                ans = ans - ans / cnt;
            }

            res += ans;
        }
        System.out.println(res);
    }

}

