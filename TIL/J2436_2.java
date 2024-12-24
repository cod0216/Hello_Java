package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2436_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        long gcd = Long.parseLong(input[0]);
        long lcm = Long.parseLong(input[1]);

        long v = gcd * lcm;

        long x = 0;
        long y = 0;

        for(long i = gcd; i<=Math.sqrt(v); i +=gcd){
            if(v%i == 0 && gcd(i,v/i)==gcd){
                x = i;
                y = v/i;
            }
        }
        System.out.println(x + " " + y);
    }

    public static long gcd(long x, long y) {
        if(y == 0) return x; //cycle end
        return gcd(y, x % y);
    }
}
