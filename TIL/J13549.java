package TIL;

import java.io.*;
import java.util.*;

/*
수빈이는 동생과 숨바꼭질을 한다
점 N에 수빈이 있고 점 K에 동생이 있다
수빈이 순간이동 가능 0초 후 2*x 좌표까지 이동 가능
수빈이 1초후 위치가 x-1또는 x+1로 이동하게 된다.

동생 잡는데 가능 빠른 시간 몇초 인지 구하셈

BFS depth 로 구하기

 */
public class J13549 {
    static int y, min, max;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        min = 100000;
        max = 100000;
        visited = new boolean[100001];

        BFS(x,0);

        System.out.println(min);

    }

    public static void BFS(int start, int t){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, t});

        while(!queue.isEmpty()){
            int[] dir = queue.poll();
            int x = dir[0];
            int time = dir[1];
            visited[x] = true;
            if(x == y) min = Math.min(min,time);

            if(x*2 <= max && !visited[x*2]) queue.offer(new int[]{x*2, time});

            if(x+1 <= max && !visited[x+1]) queue.offer(new int[]{x+1, time+1});

            if(x-1 >= 0  && !visited[x-1]) queue.offer(new int[]{x-1, time+1});

        }
    }
}
