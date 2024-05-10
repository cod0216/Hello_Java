package TIL;

import java.util.*;
import java.io.*;
public class J21568 {
    static Stack<Long> stack = new Stack<>();
    static long x;
    static long y;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        long A = Integer.parseInt(input[0]);
        long B = Integer.parseInt(input[1]);
        long C = Integer.parseInt(input[2]);

        long min = Math.min(A, B);
        long max = Math.max(A, B);
        
        stack.push(A/B);
        long gcd = gcd(max,min);
        
        if( C % gcd != 0){
            System.out.println(-1);
            return;
        }
        
        euclid(1, 0);
        long num = C/gcd;
        System.out.println(x*num +" " + y*num);

    }

    public static void euclid(long a, long b){
        if(stack.isEmpty()){
            x = a; y = b;
            return;
        }

        euclid(b,a-(b*stack.pop()));
    }
    public static long gcd(long max, long min){
        if(min==0) {
            return max;
        }

        stack.push(max/min);
        return gcd(min,max%min);
    }

}
