import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		
		int[][] map = new int[101][101];
		
		for(int i = 0 ; i < N; i++) {
			input = buffer.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			int d = Integer.parseInt(input[3]);
			
			for(int j = a; j <= c; j++) {
				for(int z = b; z <= d; z++) {
					map[j][z] += 1;
				}
			}
		}
		int cnt = 0;
		for(int i = 1 ; i <= 100; i++) {
			for(int j = 1 ; j <= 100; j++) {
				if(map[i][j] > M) cnt++; 
			}
		}
		
		System.out.println(cnt);
	}
}
