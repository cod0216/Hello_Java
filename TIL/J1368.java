package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class J1368 {
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        parents = new int[N+1];
        PriorityQueue<int[]> map = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        boolean flag = false;

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            map.offer(new int[]{0, i,Integer.parseInt(buffer.readLine())});
            parents[i] = i;
        }

        for (int i = 1; i <=N; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 1; j <=N; j++) {
                if(i == j) continue;
                map.add(new int[]{i,j,Integer.parseInt(input[j-1])});
            }
        }

        int ans = 0;
        while(!map.isEmpty()){
            int[] e = map.poll();
            if(find(e[0]) != find(e[1])){
                union(e[0], e[1]);
                ans += e[2];
            }
        }
        System.out.println(ans);
    }

    public static int find (int num){
        if(parents[num] != num) return parents[num] = find(parents[num]);
        return parents[num];
    }

    public static void union(int a, int b){
       int max = Math.max(find(a),find(b));
       int min = Math.min(find(a),find(b));

       if(max != min) parents[max] = min;
    }
}
