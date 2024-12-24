package TIL;

import java.io.*;

public class J11689_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(buffer.readLine());

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
    }
}
