import java.util.*;
import java.io.*;
class Temp implements Comparable<Temp>{
	int s;
	int e;
	
	public Temp(int s,int e) {
		this.s = s;
		this.e = e;
	}
	
	public int compareTo(Temp o) {
		if(this.s == o.s) return o.e - this.e;
		return this.s - o.s;
	}
}
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		int[] arr = new int[367];
		PriorityQueue<Temp> queue = new PriorityQueue<>();
		for(int i = 0; i < N; i++) {
			String[] input = buffer.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			queue.offer(new Temp(a, b));			
		}
		
		while(!queue.isEmpty()) {
			Temp cur = queue.poll();
			int cs = cur.s; int ce = cur.e;
			for(int i = cs; i <= ce; i++) {
				arr[i]++;
			}
		}
		int start = 0;
		int ans = 0;
		int max = 0;
		for(int i = 0; i <= 366; i++) {
			max = Math.max(max, arr[i]);
			
			if(arr[i] == 0) {
				int inteval = i-start; 
				ans += max * inteval;
				max = 0;
				start = i+1;
			}
		}
		System.out.println(ans);
	}
	

}
