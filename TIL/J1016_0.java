package TIL;

import java.util.*;
import java.io.*;

public class J1016_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);
        int cnt = 0;

        boolean[] check = new boolean[(int)(max-min)+1];


        for(long i =2; i<= Math.sqrt(max); i++){
            long pow = i*i;
            long startNum = min/pow;
            if(min%pow != 0){
                startNum++;
            }
            for(long j = startNum; j<=max/pow; j++){
                check[(int)(j*pow-min)] = true;
            }
        }
        for(int i = 0; i<check.length; i++){
            if(!check[i]){
                cnt++;
            }
        }

        System.out.println("cnt = " + cnt);

    }
}
