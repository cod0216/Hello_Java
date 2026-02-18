import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(buffer.readLine());
		while(T>0) {
			String[] input = buffer.readLine().split(" ");
			int A = Integer.parseInt(input[0]);
			int distance = Integer.parseInt(input[1]);
			int cnt = 0;
			for(int i = 0; i < A; i++) {
				input = buffer.readLine().split(" ");
				float a = Float.parseFloat(input[0]);
				float b = Float.parseFloat(input[1]);
				float c = Float.parseFloat(input[2]);
				
				float temp = b/c;
				if(a*temp >= distance) cnt++;
			}
			System.out.println(cnt);
			T--;
		}
	}
}
