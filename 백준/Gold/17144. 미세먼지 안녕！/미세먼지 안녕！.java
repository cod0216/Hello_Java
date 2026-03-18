import java.util.*;
import java.io.*;

public class Main {
	static int R, C, T;
	static int INIT = -1;
	static int upX, upY;
	static int downX, downY;
	static int[][] map;
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = buffer.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		T = Integer.parseInt(input[2]);
		
		upX = INIT; upY = INIT;
		downX = INIT; downY = INIT;
		
		map = new int[R][C];
		
		for(int i = 0; i < R; i++) {
			input = buffer.readLine().split(" ");
			for(int j = 0; j < C; j++) {
				int v = Integer.parseInt(input[j]);
				map[i][j] = v;
				
				if(v == -1) {
					if(upX == INIT) {
						upX = i; upY = j;
					}else {
						downX = i; downY = j;
					}
				}
			}
		}
		
		while(T --> 0) {
			spread();
			cleanUp();
			cleanDown();
		}
		
		System.out.println(count()+2);
	}
	public static int count() {
		int ans = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				ans += map[i][j];
			}
		}
		return ans;
	}
	
	public static void spread() {
		int[][] temp = new int[R][C];
		
		temp[upX][upY] = -1;
		temp[downX][downY] = -1;
		
		for(int x = 0; x < R; x++) {
			for(int y = 0; y < C; y++) {
				if(map[x][y] <= 0 ) continue;
				int dust = map[x][y];
				int amount = dust / 5;
				int count = 0;
				for(int d = 0; d < 4; d++ ) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(!isIn(nx, ny)) continue;
					if(map[nx][ny] == -1) continue;
					temp[nx][ny] += amount;
					count++;	
				}
				temp[x][y] += dust - (amount * count);	
			}
		}
		map = temp; 
	}
	
	public static void cleanUp() {
		List<int[]> pos = new ArrayList<>();
		
		for(int y = 1; y < C; y++ ){
			pos.add(new int[] {upX, y});
		}
		
		for(int x = upX-1; x >= 0; x-- ){
			pos.add(new int[] {x, C-1});
		}
		
		for(int y = C-2; y >= 0; y-- ){
			pos.add(new int[] {0, y});
		}
		
		for(int x = 1; x < upX; x++ ){
			pos.add(new int[] {x, 0});
		}
		
		List<Integer> values = new ArrayList<>();
		values.add(0);
		
		for(int i = 0; i < pos.size() -1 ; i++) {
			int[] p = pos.get(i);
			values.add(map[p[0]][p[1]]);
		}
		
		for(int i = 0; i < pos.size(); i++) {
			int[] p = pos.get(i);
			map[p[0]][p[1]] = values.get(i); 
		}
	}
	
	public static void cleanDown() {
		List<int[]> pos = new ArrayList<>();
		
		for(int y = 1; y < C; y++ ){
			pos.add(new int[] {downX, y});
		}
		
		for(int x = downX+1; x < R; x++ ){
			pos.add(new int[] {x,C-1});
		}
		
		for(int y = C-2; y >= 0; y-- ){
			pos.add(new int[] {R-1, y});
		}
		
		for(int x = R-2; x > downX; x-- ){
			pos.add(new int[] {x, 0});
		}
		
		List<Integer> values = new ArrayList<>();
		values.add(0);
		
		for(int i = 0; i < pos.size() -1 ; i++) {
			int[] p = pos.get(i);
			values.add(map[p[0]][p[1]]);
		}
		
		for(int i = 0; i < pos.size(); i++) {
			int[] p = pos.get(i);
			map[p[0]][p[1]] = values.get(i);
		}
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y <C; 
		
	}

}
