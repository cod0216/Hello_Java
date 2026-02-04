import java.util.*;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(buffer.readLine());
		
		int[] arr = new int[14];
		String[] input = buffer.readLine().split(" ");
		for(int i = 0 ; i < 14; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int m = M;
		int cnt = 0;
		for(int i = 0 ; i < 13; i++) {
			if(arr[i]<= m) {
				int c = m/arr[i];
				 m = m - c*arr[i];
				 cnt = cnt + c;
			}
		}
		int a = cnt * arr[13]+m;
		
		m = M;
		cnt = 0;
		int up = 0;
		int down = 0;
		int prior = arr[0];
		for(int i = 1 ; i < 13; i++) {
			if(up >= 2 || down >= 2) {
				if(down >= 2) {
					int c = m/arr[i];
					 m = m - c*arr[i];
					 cnt = cnt + c;
					 down = 0;
				}
				if(up >= 2) {
					m += cnt * arr[13];
				}
			}
			if(prior < arr[i]) {
				up++;
				down = 0;
			}else if(prior > arr[i]) {
				down++;
				up = 0;
			}
		}
		
		int b = arr[13] * cnt + m;
		
//		System.out.println("a : " + a + ", b : " + b);
		
		if(a == b) {
			System.out.println("SAMESAME");
		}else {
			System.out.println(a>b ? "BNP" : "TIMING");	
		}
	}
}
