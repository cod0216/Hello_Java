package TIL;

import java.io.*;
import java.util.*;

public class J1260 {
    static LinkedList<Integer>[] A;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        int startNum = Integer.parseInt(input[2]);
        visited = new boolean[node + 1];
        A = new LinkedList[node + 1];
        for (int i = 0; i <= node; i++) {
            A[i] = new LinkedList<>();
        }
        for (int i = 0; i < edge; i++) {
            input = bufferedReader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            A[n].add(m);
            A[m].add(n);
        }

        for(int i = 1; i <= node; i++){
            Collections.sort(A[i]);
        }

        DFS(startNum);
        visited = new boolean[node+1];
        System.out.println();
        BFS(startNum);

    }

    private static void DFS(int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int i : A[node]) {
            if (!visited[i])
                DFS(i);
        }
    }

    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int n = queue.poll();
            System.out.print(n + " ");
            for(int i : A[n]) {
                if (!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
