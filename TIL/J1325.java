package TIL;

import java.util.*;
import java.io.*;


public class J1325 {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static int max = 0;
	static int[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = buffer.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		check = new int[N+1];
		StringBuilder builder = new StringBuilder();
		
		A = new ArrayList[N+1];
		
		
		for(int i = 0; i<= N;i++) {
			A[i] = new ArrayList<>();
		}
		
		for(int i = 0; i<M; i++) {
			input= buffer.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			A[start].add(end);
		}
		for(int i =1; i<=N; i++) {
			visited = new boolean[N+1];
//			dfs(i, 0);
			bfs(i, 0);
		}
		int max = 0;
		for(int i =1; i<=N; i++) {
			if(max < check[i]) max = check[i];
		}
		
		for(int i =1; i<=N; i++) {
			if(max == check[i])
				builder.append(i + " ");
		}
		System.out.println(builder);
		
		
	}
	public static void bfs(int node, int deth) {
		Queue<Integer> queue = new LinkedList<>();
		visited[node] = true;
		queue.add(node);
		check[node] = deth;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i : A[now]) {
				if(!visited[i]) {
					check[i] = check[now]+1;
					visited[i] = true;
					queue.add(i);
				}
			}
		}
	}
	public static void dfs(int node, int deth) {
		visited[node] = true;
		
		for(int i : A[node]) {
			if(!visited[i]) {
				check[i] = deth+1;
				dfs(i,deth+1);
			}
		}
		
	}
}