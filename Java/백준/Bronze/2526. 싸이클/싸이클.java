import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		String[] input = buffer.readLine().split(" ");
		
		int N = Integer.parseInt(input[0]);
		int M = Integer.parseInt(input[1]);
		boolean flag = true;
		
		HashMap<Integer,Integer> map = new HashMap<>();
		int cnt = 1;
		int ans = 0;
		map.put(N,cnt);
		int last = N;
		while(flag) {
			cnt++;
			last = last*N%M;
			if(last != N && map.containsKey(last)) flag = !flag;	
			else map.put(last,cnt);
		}
        
        ans = cnt - map.get(last);
		System.out.print(ans);
	}
}
