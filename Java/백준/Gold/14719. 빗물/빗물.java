import java.io.*;
import java.util.*;

public class Main {
	static int h, w, map[][], height[];

	public static void main(String[] args) throws IOException {

		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		String[] input = buffer.readLine().split(" ");

		h = Integer.parseInt(input[0]);
		w = Integer.parseInt(input[1]);

		map = new int[h][w];
        height = new int[w];
        
		input = buffer.readLine().split(" ");

		for (int i = 0; i < w; i++) {
			height[i] = Integer.parseInt(input[i]);
		}

		System.out.println(rain());
	}

	public static int rain() {
		int sum = 0;
		for (int i = 1; i < w - 1; i++) {

			int now = height[i];

			int lMax = 0;
			for (int j = 0; j <= i; j++) {
				lMax = Math.max(lMax, height[j]);
			}

			int rMax = 0;
			for (int j = i; j < w; j++) {
				rMax = Math.max(rMax, height[j]);
			}

			sum += Math.min(lMax, rMax) - now;
		}
		if (sum < 0)
			sum = 0;
		return sum;

	}
}
