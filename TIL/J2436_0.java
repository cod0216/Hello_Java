package TIL;

import java.util.*;
import loop.for1;

import java.io.*;

public class J2436_0 {
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		long gcd = Long.parseLong(input[0]);
		long lcm = Long.parseLong(input[1]);
		
		long value = gcd * lcm;
		long x=0;
		long y=0;
		
		for(long i = gcd; i <Math.sqrt(value); i +=gcd) {
			if(value%i ==0 && euclid(i, value/i)==gcd) {
				x = i;
				y = value/i;
			}
		}
		
		System.out.println(x + " " + y);
	}
	
	public static long euclid(long max, long min) {
		if(min == 0) return max;
		return euclid(min, max%min);
	}
}
