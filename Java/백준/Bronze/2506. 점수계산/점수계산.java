import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(buffer.readLine());
		String[] input = buffer.readLine().split(" ");
		int c = 1;
		int sum = 0;
		for(int i = 0; i < N ; i++) {
			int v = Integer.parseInt(input[i]);
			if(v == 0 ) {
				c = 1;
				continue;
			}
			sum += c++;
		}
		System.out.println(sum);
	}
}
