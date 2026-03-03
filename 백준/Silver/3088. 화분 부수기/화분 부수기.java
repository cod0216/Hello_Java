import java.util.*;
import java.io.*;


public class Main {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(buffer.readLine());
		
		boolean[] broken = new boolean[1000001];
		int cnt = 0;
		
		for(int i = 0; i < N; i++) {
			String[] input = buffer.readLine().split(" ");
			
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			int c = Integer.parseInt(input[2]);
			if(!broken[a] && !broken[b] && !broken[c]) cnt++;
			
			broken[a] = true;
			broken[b] = true;
			broken[c] = true;
		}
		
		System.out.println(cnt);
		
		
		
		
	}
	public static int find(int n) {
		if(parents[n] != n) return parents[n] = find(parents[n]);
		return n;
	}
	
	public static void union(int a, int b) {
		int max = Math.max(parents[a], parents[b]);
		int min = Math.min(parents[a], parents[b]);
		
		parents[max] = min;
	}
}
