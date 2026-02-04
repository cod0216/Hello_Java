import java.util.*;
import java.io.*;
public class Main {
	static int N, K;
	static LinkedList<Integer> list;
	static LinkedList<Integer> robot;
	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
		list = new LinkedList<>();
		robot = new LinkedList<>();
		String[] input = buffer.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		
		input = buffer.readLine().split(" ");
		for(int i = 0 ; i < 2*N; i++) {
			int v = Integer.parseInt(input[i]);
			list.offer(v);
		}
		int t = 0;
		int cnt = 0;
		while(cnt< K) {
			// 벨트 회전
			rotate();
			
			// 로봇 이동
			robotMove();
			
			// 로봇 올리기
			robotUp();
			
			// 개수 세기
			cnt = count();
			t++;
		}
		
		System.out.println(t);
		
	}
	
	public static void rotate() {
		list.offerFirst(list.removeLast());
		for(int i = 0 ; i < robot.size(); i++) {
			robot.set(i, robot.get(i)+1);	
		}
	
		for(int i = 0 ; i < robot.size(); i++) {
			if(robot.get(i) == N-1) {
				robot.remove(i);
				i--;
			}
		}	
	}
	
	public static void robotMove() {
		for(int i = 0; i<robot.size(); i++) {
			int idx = robot.get(i);
			int next = idx+1;
			
			if(next >= N) continue;
			
			if(robot.contains(next)) continue;
			
			if(list.get(next) == 0) continue;
			
			robot.set(i, next);
			list.set(next, list.get(next)-1);
			
			if(next == N-1) {
				robot.remove(i);
				i--;
			}
		}
	}
	
	public static void robotUp() {
		if(list.get(0) > 0 && !robot.contains(0)) {
			robot.offer(0);
			list.set(0, list.get(0)-1);
		}
	}
	
	public static int count() {
		int c = 0;
		for(int i : list) {
			if(i == 0) {
				c++;
			}
		}
		return c;
	}

}
