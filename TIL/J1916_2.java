package TIL;

import java.util.*;
import java.io.*;


public class J1916_2 {

    static List<int[]>[] list;
    static boolean[] visited;
    static int[] dist;
    static  int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        M = Integer.parseInt(buffer.readLine());
        list = new List[N+1];
        dist = new int[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <N+1; i++) {
            list[i] = new LinkedList<>();
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        String[] input;
        for (int i = 0; i <M; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            list[start].add(new int[]{end, w});
        }
        input = buffer.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        int ans = diksta(start, end);
        System.out.println(ans);
    }

    private static int diksta(int start, int end) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[start] = 0;
        queue.offer(new int[]{start, 0});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int w = cur[1];
            if(visited[x]) continue;
            visited[x] = true;
            for(int[] now : list[x]){
                if(dist[now[0]] > dist[x] + now[1]){
                    dist[now[0]] = dist[x] + now[1];
                    queue.offer(new int[]{now[0], dist[now[0]]});
                }
            }
        }
        return dist[end];
    }
}
