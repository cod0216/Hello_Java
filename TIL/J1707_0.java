package TIL;

import java.util.*;
import java.io.*;

public class J1707_0 {
	static LinkedList<Integer>[] A;
	static int[] color;
	static boolean[] visited;
	static boolean check;
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(buffer.readLine());
		
		for(int k = 0; k < K; k++) {
			String[] input = buffer.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int E = Integer.parseInt(input[1]);
			
			check = false;
			
			A = new LinkedList[N+1];
			color = new int[N+1];
			visited = new boolean[N+1];
			
			for(int i = 0; i <= N; i++) {
				A[i] = new LinkedList<Integer>();
			}
			
			for(int i = 0; i<E; i++) {
				input = buffer.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				
				A[start].add(end);
				A[end].add(start);

			}
			for(int i = 1; i<=N; i++) {
//				DFS(i, color[i]);
				BFS(i, color[i]);
//				System.out.println(color[i]);
			}
			
			if(check == true) System.out.println("NO");
			else System.out.println("YES");
			
		}

	}
	public static void DFS(int node, int num) {
		visited[node] = true;
		color[node] = num%2;
//		System.out.println("node = " + node + ", num = " + num);
		for(int i : A[node]) {
			if(!visited[i]) {
				DFS(i, num+1);
				
			}else {
				if(color[i] == (num)%2) {
//					System.out.println("node = " + node + ", i = " + i + ", color["+i+"] = "+ color[i] + ", (num+1)%2 = " + (num+1)%2 );
					check = true;
					return;
				}
			}
		}
	}
	
	public static void BFS(int n, int num) {
    	Queue<Integer> queue = new LinkedList<>();
    	queue.add(n);
    	color[n] = num%2;
    	while(!queue.isEmpty()) {
    		int now = queue.poll();
    		for(int i : A[now]) {
    			if(!visited[i]) {
    				color[i] = (color[now] +1)%2;
    				visited[i] = true;
    				queue.add(i);
    			}else {
    				if(color[i] == color[now]) {
    					check = true;
    					return;
    				}
    			}
    		}
    	}
    }
}
