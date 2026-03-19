import java.util.*;
import java.io.*;


public class Main {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans = Integer.MIN_VALUE;
	static int dx[] = new int[] {1, 0, -1, 0};
	static int dy[] = new int[] {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			input = buffer.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				int v = Integer.parseInt(input[j]);
				map[i][j] = v;
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i,j, map[i][j], 1);
				visited[i][j] = false;
			}
		}
		System.out.println(ans);
	}
	
	public static void dfs(int x, int y, int sum, int count) {
		if(count == 4) {
			ans = Math.max(sum, ans);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!isIn(nx,ny) || visited[nx][ny]) continue;
				
				if(count == 2) {
					visited[nx][ny] = true;
					dfs(x,y, sum + map[nx][ny], count+1);
					visited[nx][ny] = false;
				}
				
				visited[nx][ny] = true;
				dfs(nx,ny, sum + map[nx][ny], count+1);
				visited[nx][ny] = false;
		}
		
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M; 
	}
}
