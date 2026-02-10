import java.util.*;
import java.io.*;

public class Main {
	static int N, M;
	static boolean right[][];
	static boolean down[][];
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		right = new boolean[N+1][M+1];
		down = new boolean[N+1][M+1];
		
		int K = Integer.parseInt(buffer.readLine());
		
		for(int i = 0; i < K; i++) {
			input = buffer.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			int d = Integer.parseInt(input[3]);
			if(a == c) {
				right[a][Math.min(d, b)] = true;
			}else {
				down[Math.min(a, c)][b] = true;
			}
		}
		long[][] dp = new long[N+1][M+1];
		dp[0][0] = 1;
		
		for(int x = 0; x <= N; x++) {
			for(int y = 0; y <= M; y++) {
				if(x==0 && y==0) continue;
				
				long up = 0;
				long left = 0;
				
				if(x > 0 && !down[x-1][y]) {
					up = dp[x-1][y];
				}
				
				if(y>0 && !right[x][y-1]) {
					left = dp[x][y-1];
				}
				
				dp[x][y] = up + left;
			}
		}
		
		System.out.println(dp[N][M]);
	}
}
