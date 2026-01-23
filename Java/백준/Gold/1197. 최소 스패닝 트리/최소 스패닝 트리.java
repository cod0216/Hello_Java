import java.util.*;
import java.io.*;

public class Main {
	static int N, M, parents[];
	static PriorityQueue<int[]> list;
	public static void main(String[] args)throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		parents = new int[N+1];
		for(int i = 1; i<= N; i++) {
			parents[i] = i;
		}
		list = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
		
		for(int i = 0; i < M; i++) {
			input = buffer.readLine().split(" ");
			int s = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			list.add(new int[] {s, e, w});
		}
		int ans = 0;
		for(int i = 0; i < M; i++) {
			int[] cur = list.poll();
			int s = cur[0]; int e = cur[1]; int w = cur[2];
			if(parents[find(s)] != parents[find(e)]) {
				union(s, e);
//				System.out.println("흠");
				ans += w;
			}
		}
		System.out.println(ans);
	}
	public static int find(int n) {
		if(parents[n] != n) return parents[n] = find(parents[n]);
		return n;
	}
	public static void union(int a, int b) {
		int max = Math.max(find(a), find(b));
		int min = Math.min(find(a), find(b));
		
		parents[max] = min;
	}
}
