import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[] arr = new int[N+1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = i;
		}
		
		for(int i = 0; i < M ; i ++) {
			input = buffer.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);

			while(a<b) {
				int temp = arr[a];
				arr[a] = arr[b];
				arr[b] = temp;
				a++;
				b--;
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
