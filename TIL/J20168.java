package TIL;

import java.io.*;
import java.util.*;

public class J20168 {
    static int n, m, start, end, c, maxCost, maxCosts[];
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        start = Integer.parseInt(input[2]);
        end = Integer.parseInt(input[3]);
        c = Integer.parseInt(input[4]);

        maxCosts = new int[n+1];
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        Arrays.fill(maxCosts, Integer.MAX_VALUE);

        for(int i = 0 ; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            list[node].add(new int[]{end,cost});
            list[end].add(new int[]{node,cost});
        } //입력 완료

        money();
        System.out.println(maxCosts[end] > c ? -1 : maxCost);
    } //main end
    public static void money(){
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o ->o[1]));
        queue.add(new int[]{start,0});
        maxCosts[start] = 0;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int e = cur[0];
            int currentMaxCost = cur[1];

            if (e == end) {
                maxCost = currentMaxCost;
                return;
            }

            if (visited[e]) continue;
            visited[e] = true;

            for (int[] now : list[e]) {
                int nextNode = now[0];
                int edgeCost = now[1];
                int newMaxCost = Math.max(currentMaxCost, edgeCost);

                if (!visited[nextNode] && newMaxCost < maxCosts[nextNode]) {
                    maxCosts[nextNode] = newMaxCost;
                    queue.add(new int[]{nextNode, newMaxCost});
                }
            }
        } // q while end
    }
}
