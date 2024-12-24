package TIL;

import java.util.*;
import java.io.*;
public class J10986_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        long[] mod = new long[m];
        input = buffer.readLine().split(" ");
        long sum = 0;

        for(int i = 0; i < n; i++){
            sum += Integer.parseInt(input[i]);
            mod[(int)(sum%m)]++;
        }

        long ans = mod[0];

        for(int i = 0; i < m; i++){
            if(mod[i]>1){
                ans += (mod[i] * (mod[i]-1))/2;
            }
        }
        System.out.println(ans);
    }
}



