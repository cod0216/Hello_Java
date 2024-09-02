
package TIL;

import java.io.*;
import java.util.*;

public class J1753_2 {
    static ArrayList<int[]>[] list;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int V  = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);

        list = new ArrayList[V+1];

        for(int i = 0 ; i <= V; i++) {
            list[i] = new ArrayList<>();
        }


        int start = Integer.parseInt(buffer.readLine());
        for(int i = 0; i < E; i++) {
            input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list[node].add(new int[] {edge, weight});

        }

        arr = new int[V+1];
        visited = new boolean[V+1];


        for(int i = 0 ; i <= V ; i++) {
            if(i == start) continue;
            arr[i] = Integer.MAX_VALUE;
        }

        dikstra(start);

        for(int i = 1; i <= V; i++) {
            if(arr[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(arr[i]);
        }
    }
    public static void dikstra(int n) {
        visited[n] = true;
        for(int[] node : list[n]) {
            if(!visited[node[0]]) {
                arr[node[0]]= Math.min(arr[n]+node[1], arr[node[0]]);
//				dikstra(node[0]);
            }
        }
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i = 1; i < arr.length; i++) {
            if(!visited[i]) {
                if(arr[i] < min) index = i;
                min = Math.min(min, arr[i]);

            }
        }
        if(!visited[index]) dikstra(index);
    }

}
