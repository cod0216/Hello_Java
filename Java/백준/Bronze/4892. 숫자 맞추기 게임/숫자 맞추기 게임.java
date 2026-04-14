import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		int count = 1;

		while(true) {
			int n = Integer.parseInt(buffer.readLine());

			if(n == 0) break;
			if(n % 2 == 0) {
				n = (((n * 3) / 2) * 3) / 9;
				System.out.println(count + ". even " + n);
			}else {
				n = ((((n * 3) + 1) / 2) * 3) / 9;
				System.out.println(count + ". odd " + n);
			}
			count++;
		}
	}

}