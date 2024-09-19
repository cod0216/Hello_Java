package TIL;

import java.io.*;
import java.util.*;
/*

농부 현서는 헛간 1에 있음
농부 찬홍이도 헛간 N에 있음

N과 M이 주어짐
둘째 M+1번쨰 까지 A, B, C가 주어짐

다익스트라? go

 */

public class J5972 {
    static int n, m, distance[];
    static boolean[] visited;
    static LinkedList<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        list = new LinkedList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i <m; i++ ){
            input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int wight = Integer.parseInt(input[2]);

            list[node].add(new int[]{end, wight});
            list[end].add(new int[]{node, wight});
        } //input end

        dijkstra();

        System.out.println(distance[n]);

    }//main end

    public static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        visited = new boolean[n+1];
        pq.offer(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cx = cur[0];
                for (int[] now : list[cx]) {
                    int nx = now[0];
                    if (distance[nx] > distance[cx] + now[1]) {
                        distance[nx] = distance[cx] + now[1];
                        pq.offer(new int[]{nx, distance[nx]});
                    }
                }

        } // pq while end
    }
}
