package TIL;

import java.io.*;
import java.util.*;

public class J1647 {
    public static int parents[];
    public static int find(int n){
        if(parents[n] != n) return parents[n] = find(parents[n]);
        return parents[n];
    }

    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));

        if(min != max) parents[max] = min;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2]-b[2]);

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        parents = new int[N+1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < M; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            queue.offer(new int[]{start, end, weight});
        }
        int ans = 0;
        int max = 0;
        while(!queue.isEmpty()){
            int[] e = queue.poll();

            if(find(e[0]) != find(e[1])){
                ans += e[2];
                max = Math.max(e[2], max);
                union(e[0], e[1]);
            }
        }

        System.out.println(ans-max);
    }
}
