import java.util.*;
import java.io.*;
class Shark implements Comparable<Shark>{
	int posX;
	int posY;
	int dist;
	
	public Shark(int posX, int posY, int dist) {
		this.posX = posX;
		this.posY = posY;
		this.dist = dist;
	}
	
	@Override
	public int compareTo(Shark o) {
		if(this.dist == o.dist) {
			if(this.posX == o.posX) {
				return this.posY - o.posY;
			}
			return this.posX- o.posX;
		}
		return this.dist - o.dist;
	}
	
}

public class Main {
	static int map[][], N;
	static int dx[] = new int[]{1,0,-1,0};
	static int dy[] = new int[] {0,-1,0,1};
	static int posX, posY, size = 2, temp=0;
	static PriorityQueue<Shark> eat;
	static int state;
	static boolean[][] visited; 
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(buffer.readLine());
		
		map = new int[N][N];
		
		for(int i = 0 ; i < N; i++) {
			String[] input = buffer.readLine().split(" ");
			for(int j = 0 ; j< N; j++) {
				int v = Integer.parseInt(input[j]);
				if(v == 9) {
					posX = i;	posY = j;
				}
				else map[i][j] = v;
			}
		}
		
		play();
		
	}
	
	public static void play() {
		while(true){
			canEat();
			if(eat.isEmpty()) {
				System.out.println(state);
				return;
			}
			eat();
		}
		
		
	}
	
	public static void canEat() {
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.offer(new int[] {posX, posY, 0});
		eat = new PriorityQueue<>();
		visited = new boolean[N][N];
		visited[posX][posY] = true;
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int d = 0 ; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];
				int dist = cur[2]+1;
				
				if(isIn(nx, ny) && !visited[nx][ny]) {
					visited[nx][ny] = true;
					if(map[nx][ny] <= size) {
						queue.offer(new int[] {nx,ny,dist});
					}
					if(map[nx][ny] != 0 && map[nx][ny] < size) {
						eat.offer(new Shark(nx,ny,dist));
					}
				}
			}
		}
	}
	
	public static void eat() {		
		Shark shark = eat.poll();
		posX = shark.posX;
		posY = shark.posY;
		state += shark.dist;
		
		map[posX][posY] = 0;
		
		temp++;
		if(temp == size) {
			size ++;
			temp = 0;
		}
		
	
	}
	
	public static boolean isIn(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y <N;
	}
}
