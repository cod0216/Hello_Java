package TIL;

import java.util.*;
import java.io.*;


public class J1325 {
	static LinkedList<Integer>[] A;
	static boolean[] visited;
	static int[] check;
	static int max = 0;
	
	public static void main(String[] args)throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		A = new LinkedList[N+1];
		check = new int[N+1];
		
		for(int i =0; i<=N; i++) {
			A[i] = new LinkedList<>();
		}
		
		for(int i = 0; i<M; i++) {
			input = buffer.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			A[end].add(start);
		}
		
		int largeMax = 0;
		visited = new boolean[N+1];	
		for(int i =1; i<=N; i++) {
			if(visited[i]) continue;	
			DFS(i,0);
			check[i] = max;
			if(largeMax<max) largeMax = max;
			max = 0;
		}
		
		for(int i =1; i<=N; i++) {
			if(check[i] == largeMax) {
				System.out.print(i + " ");
			}
		}
	}
	public static void DFS(int node, int dept) {
		visited[node] = true;
		if(max<dept) {
			max = dept;
		}
		for(int i : A[node]) {
			if(!visited[i]) {
				DFS(i,dept+1);
			}
			else {
				max +=dept;
			}
		}
	}
}
//이거 반대로 연결해서 해야되네