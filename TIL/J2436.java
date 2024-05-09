package TIL;

import java.util.*;
import java.io.*;
public class J2436 {
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        long gcd = Long.parseLong(input[0]);
        long lcd = Long.parseLong(input[1]);

        long value = gcd*lcd;

        long x = 0;
        long y = 0;

        for(long i = gcd; i <= Math.sqrt(value); i = i+gcd){
            if(value % i == 0 && euclid(i, value/i) == gcd){
                x = i;
                y = (value/i);
            }
        }
        System.out.println(x + " " + y);
    }

    public static long euclid(long a, long b){
        if(b == 0) return a;
        return euclid(b,a%b);
    }
}
