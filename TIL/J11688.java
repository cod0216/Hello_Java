package TIL;

import java.util.*;
import java.io.*;

public class J11688 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);
        long L = Long.parseLong(input[2]);

        long lcm_ab = lcm(a, b);

        // Check if L is divisible by lcm_ab
        if(L % lcm_ab != 0){
            System.out.println(-1);
            return;
        }

        // Find all divisors of L
        List<Long> divisors = getDivisors(L);
        Collections.sort(divisors);

        long result = -1;

        for(long c : divisors){
            long current_lcm = lcm(lcm_ab, c);
            if(current_lcm == L){
                result = c;
                break; // Found the smallest c
            }
        }

        System.out.println(result);
    }

    // Function to compute GCD using Euclidean algorithm
    public static long gcd(long a, long b){
        while(b != 0){
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    // Function to compute LCM using GCD
    public static long lcm(long a, long b){
        return (a / gcd(a, b)) * b;
    }

    // Function to find all divisors of a number
    public static List<Long> getDivisors(long n){
        List<Long> divisors = new ArrayList<>();
        long sqrt_n = (long)Math.sqrt(n);
        for(long i = 1; i <= sqrt_n; i++){
            if(n % i == 0){
                divisors.add(i);
                if(n / i != i){
                    divisors.add(n / i);
                }
            }
        }
        return divisors;
    }
}
