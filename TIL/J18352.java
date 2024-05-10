package TIL;

import java.util.*;
import java.io.*;

public class J18352 {
	static LinkedList<Integer>[] A;
	static int[] check;
	static int max;
	public static void main(String[] args) throws IOException{
		
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		int node = Integer.parseInt(input[0]);
		int load = Integer.parseInt(input[1]);
		max = Integer.parseInt(input[2]);
		int startNode = Integer.parseInt(input[3]);
		
		A = new LinkedList[node+1];
		check = new int[node+1];
		
		for(int i = 0; i<= node; i++) {
			A[i] = new LinkedList<Integer>();
		}
		
		for(int i = 0; i< load; i++) {
			input = buffer.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int e = Integer.parseInt(input[1]);
			
			A[n].add(e);
		}
		DFS(startNode, 0);
		boolean ok = false;
		 
		
		for(int i = 1; i<= node; i++) {
			if(check[i] == max) {
				System.out.println(i);
				ok = true;
			}
		}
		
		if(!ok) {
			System.out.println("-1");
		}
	}
	
	public static void DFS(int node, int value) {
		if(value>max) return;
		if(check[node] == 0 || check[node] > value) {
			check[node] = value;
		}
		for(int i : A[node]) {
			DFS(i, value+1);
		}
	}
}


