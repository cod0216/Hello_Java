package TIL;

import java.util.*;
import java.io.*;

public class J2251 {
	static int A, B, C;
	static int[] maxCapacity;
	static boolean[][] visited;
	static boolean[] availableCapicity;
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		C = Integer.parseInt(input[2]);
		
		maxCapacity = new int[] {A, B, C};
		visited = new boolean[A+1][B+1];
		availableCapicity = new boolean[C + 1];
		
		BFS();
		for(int i = 0; i < availableCapicity.length; i++) {
			if(availableCapicity[i]) System.out.print(i + " ");
		}
		
	}
	
	public static void BFS() {
		Queue<int[]> queue = new LinkedList<int[]>();
		
		queue.add(new int[] {0, 0, C});
		while(!queue.isEmpty()) {
			int[] status = queue.poll();
			visited[status[0]][status[1]] = true;
			
			if(status[0] == 0) availableCapicity[status[2]] = true;
			
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					if(i == j) continue;
					int[] newStatus = watering(status, i, j);
					if(newStatus != null && !visited[newStatus[0]][newStatus[1]]) {
						queue.add(newStatus);
					}
				}
			}
		}
		
	}
	
	public static int[] watering(int[] status, int sender, int receiver) {
		int residue = maxCapacity[receiver] - status[receiver];
		
		if(residue == 0 || status[sender] == 0 ) return null;
		
		int[] newStatus = status.clone();
		if(residue < newStatus[sender]) {
			newStatus[sender] -= residue;
			newStatus[receiver] += residue;
		} else {
			newStatus[receiver] += newStatus[sender];
			newStatus[sender] = 0;
		}
		
		return newStatus;
	
	}
}
