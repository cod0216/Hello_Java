package TIL;

import java.io.*;
import java.util.*;

public class J1016 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long min = Long.parseLong(input[0]);
        long max = Long.parseLong(input[1]);
        long gNum = (long)Math.sqrt(max);
        boolean[] check = new boolean[(int)(max-min)+1];

        for(long i = 2; i <= gNum; i++){
            long pow = i*i;
            long start = min / pow;
            if(min % pow != 0 ) start +=1;

            for(long j = start; j<max; j++){
                if(pow*j > max)break;
                check[(int)((pow*j)-min)] = true;
            }
        }
        int count= 0;
        for(int i = 0; i <check.length; i++){
            if(!check[i]){
                count++;
            }
        }

        System.out.println(count);
    }
}
