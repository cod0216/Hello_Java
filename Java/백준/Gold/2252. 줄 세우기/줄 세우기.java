import java.util.*;
import java.io.*;

public class Main {
	static int n, m, countArr[];
	static ArrayList<Integer>[] list;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] input = buffer.readLine().split(" ");

		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		visited = new boolean[n + 1];
		list = new ArrayList[n + 1];
		countArr = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			input = buffer.readLine().split(" ");

			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);

			list[start].add(end);
			countArr[end]++;
		}

		polo();
	}

	public static void polo() {
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 1; i <=n; i++) {
			if(countArr[i] == 0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println(cur); 
			
			countArr[cur]--;
			visited[cur] = true;
			for(int now : list[cur]) {
				countArr[now]--;
				if(countArr[now] == 0) queue.add(now);
			}
			
			
		}// queue while end		
	}
}
