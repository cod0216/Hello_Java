package TIL;

import java.io.*;
import java.util.*;

public class J2018_1 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());
        int[] sum = new int[n+1];

        int sumTotal = 0;

        for(int i = 0 ; i <= n; i++){
            sum[i] = sumTotal += i;
        }

        int cnt = 0;
        int start = 0;
        int end = 1;

        while(end != n+1){
            int cal = (sum[end] - sum[start]);
            if(n == cal){
                cnt++;
                end++;
            }
            else if(cal > n) start++;
            else if(cal < n) end++;
        }
        System.out.println(cnt);
    }
}
