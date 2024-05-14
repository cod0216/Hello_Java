package TIL;

import java.util.*;
import java.io.*;

public class J1717_0 {
	static int[] list;
	static boolean check = false;
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		list = new int[n+1];
		
		for(int i = 0; i<= n; i++) {
			list[i] = i;
		}
		
		int cnt = 0;
		
		while(cnt != m) {
			input = buffer.readLine().split(" ");
			int key = Integer.parseInt(input[0]);
			int a = Integer.parseInt(input[1]);
			int b = Integer.parseInt(input[2]);
			check = false;
			a = find(a);
			b = find(b);
			int x = Math.min(a, b);
			int y = Math.max(a, b);
			
			if(key == 0) {
				union(x, y);
			}
			else if(key == 1) {
				if (x == y) check = true;
				if(check) System.out.println("YES");
				else System.out.println("NO");
			}
			
			cnt++;
		}		
	}
	
	public static void union(int min, int max) {
		if (list[max]!= list[min]) list[max] = list[min];
	}
	
	public static int find(int num) {
		if (list[num] != num)  
			return list[num] = find(list[num]);
		
		return num;
	}

	
//    private static int find(int num){
//        if(num == list[num])
//            return list[num];
//        else return  list[num] = find(list[list[num]]);
//
//    }
}
