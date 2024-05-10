package TIL;

import java.util.*;
import java.io.*;

public class J21568_0 {
	
	static Stack<Long> stack = new Stack<>();
	static long value1;
	static long value2;
	
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		long A = Long.parseLong(input[0]);
		long B = Long.parseLong(input[1]);
		long C = Long.parseLong(input[2]);
		
//		long max = Math.max(A,B);
//		long min = Math.min(A,B);
		
		if(C%euclid(A,B) == 0) {
			
			exEuclid(1,0);
		
		}
		
		long num = C/euclid(A, B);
		
		value1 *= num;
		value2 *= num;
		
		System.out.println(value1 + " " + value2);
		
		
	}
	public static void exEuclid(long a, long b) {
		long pop = stack.pop();
		if(stack.isEmpty()) { value1 = b; value2 = a-pop*b; return;}
		exEuclid(b, a-pop*b);
		
	}
	
	
	public static long euclid(long x, long y) {
		if(y == 0 ) return x;
		
		stack.push(x/y);
		
		return euclid(y, x%y);
	}
}
