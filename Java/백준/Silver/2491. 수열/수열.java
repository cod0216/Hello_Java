import java.util.*;
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(buffer.readLine());
		
		String[] input = buffer.readLine().split(" ");
		
		int[] arr = new int[N];
		
		for(int i = 0; i  < N ;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int ans = 1;
		int cnt = 1;
		
		for(int i = 0 ;i  < N-1; i++) {
			if(arr[i] <= arr[i+1]) {
				cnt++;
//				System.out.println("arr[i]: " + arr[i] + ", arr[i+1]: " + arr[i+1]);
			}
			else {

				cnt = 1 ;
			}
			ans = Math.max(ans, cnt);
			
		}
		
		
//		System.out.println("==========================");
		int c = 1;
		for(int i = 0; i< N-1; i++) {
			if(arr[i] >= arr[i+1]) {
//				System.out.println("arr[i]: " + arr[i] + ", arr[i-1]: " + arr[i-1]);
				c++;
			}
			else {
				c = 1 ;
			}
			ans = Math.max(ans, c);
		}
		
		System.out.println(ans);
	}
}
