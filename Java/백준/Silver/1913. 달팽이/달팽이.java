import java.io.*;

public class Main {
	static int n;

	public static void main(String args[]) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(buffer.readLine());
		int[][] map = new int[n][n];
		int f = n;
		int x = 0;
		int y = 0;
		int num = n * n;
		int findNum = Integer.parseInt(buffer.readLine());

		for (int i = 0; i < 2 * n - 1; i++) {
			switch (i % 4) {
			case 0: {
				for (int k = 0; k < f; k++) {
					map[x][y] = num;
					num--;
					x++;
				}
				y++;
				x--;
				f--;
				break;
			}
			case 1: {
				for (int k = 0; k < f; k++) {
					map[x][y] = num;
					num--;
					y++;
				}
				x--;
				y--;
				break;
			}
			case 2: {
				for (int k = 0; k < f; k++) {
					map[x][y] = num;
					num--;
					x--;
				}
				x++;
				y--;
				f--;
				break;
			}

			case 3: {
				for (int k = 0; k < f; k++) {
					map[x][y] = num;
					num--;
					y--;
				}
				x++;
				y++;
				break;
			}

			}

		}
		int fx = 0;
		int fy = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(map[i][j] + " ");
				if(map[i][j] == findNum) {
					fx = i+1; fy = j+1;
				}
			}
			System.out.println();
		}
		System.out.println(fx + " " + fy);
	}

	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}
}