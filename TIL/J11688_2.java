package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class J11688_2 {
    static List<Long> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long L = Long.parseLong(input[2]);

        long v = lcm(a,b);
        if (L%v != 0){
            System.out.println("-1");
            return;
        } //exception

        subNumber(L);

        long result = -1;

        for(long n : list){
            if (lcm(v, n) == L) {
                if (result == -1 || n < result) {
                    result = n;
                }
            }
        }
        System.out.println(result);
    }

    public static long gcd(long x, long y){
        if(y == 0) return x;
        return gcd(y, x%y);
    }

    public static long lcm(long x, long y){
        return (x  / gcd(x,y))* y;
    }

    public static void subNumber(long l){
        long sqrt = (long)Math.sqrt(l);
        for(long i = 1; i<= sqrt; i++ ){
            if(l%i == 0 ){
                list.add(i);
                if(i != l / i) {
                    list.add(l / i);
                }
            }
        }
        Collections.sort(list);
    }
}
