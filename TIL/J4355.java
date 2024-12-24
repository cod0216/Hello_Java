package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J4355 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(buffer.readLine());
        while(n != 0){
            if(n == 1){
                System.out.println(0);
                n = Long.parseLong(buffer.readLine());
                continue;
            }// exception

            long ans = n;
            long cnt = n;

            for(int i = 2; i<= Math.sqrt(n); i++){
                if (cnt % i == 0){
                    ans = ans - ans/i;
                    while(cnt%i ==0){
                        cnt = cnt / i;
                    }
                }
            }

            if( cnt>1 ){
                ans = ans - ans/cnt;
            }

            System.out.println(ans);
            n = Long.parseLong(buffer.readLine());
        }
    }
}
