package TIL.review;

import java.util.*;
import java.io.*;

public class J1016 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        boolean[] check = new boolean[(int)(b-a)+1];





        for(long i = 2; i<= Math.sqrt(b); i++){
            long pow = i*i;
            long startNum = a/pow;
            if(a%pow != 0) startNum++;

            for(long j = startNum; j<=b/pow; j++){
                check[(int)((pow*j)-a)] = true;
            }

        }
        long cnt = 0;
        for(long i = 0; i < check.length; i++){
            if(!check[(int)i]) cnt++;
        }
        System.out.println(cnt);
    }
}
