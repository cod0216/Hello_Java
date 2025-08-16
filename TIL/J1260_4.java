package TIL;

import java.util.*;
import java.io.*;

public class J1260_4 {
    static boolean[] visited;
    static LinkedList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        int startNode = Integer.parseInt(input[2]);

        A = new LinkedList[node+1];
        visited = new boolean[node+1];

        for(int i = 0; i < node+1; i++){
            A[i] = new LinkedList<>();
        }

        for(int i =0; i < edge; i++){
            input = buffer.readLine().split(" ");
            int value1 = Integer.parseInt(input[0]);
            int value2 = Integer.parseInt(input[1]);
            int min = Math.min(value1, value2);
            int max = Math.max(value1, value2);
            A[min].add(max);
            A[max].add(min);
        }

        for(int i = 0; i < node +1; i++){
            Collections.sort(A[i]);
        }



        DFS(startNode);
        visited = new boolean[node+1];
        System.out.println();
        BFS(startNode);
    }

    private static void DFS(int node){
        visited[node] = true;
        System.out.print(node + " ");

        for(int i : A[node]){
            if(!visited[i]){
                DFS(i);
            }
        }

    }

    private static void BFS(int node){
        visited[node] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            int value = queue.poll();
            for(int i : A[value]) {
                if(!visited[i])
                    queue.add(i);
                    visited[i] = true;
            }
            System.out.print(value + " ");
        }
    }
}
