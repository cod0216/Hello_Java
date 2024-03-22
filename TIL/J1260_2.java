package TIL;

import java.util.*;
import java.io.*;

public class J1260_2 {
    static LinkedList<Integer>[] A;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        int start = Integer.parseInt(input[2]);
        visited = new boolean[node+1];
        A = new LinkedList[node+1];
        for(int i = 1; i <= node; i++){
            A[i] = new LinkedList<Integer>();
        }

        for(int i = 1; i <= edge; i++){
            input = bufferedReader.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            A[s].add(e);
            A[e].add(s);
        }
        visited[start] = true;
        DFS(start);
        System.out.println();
        visited = new boolean[node+1];
        visited[start] = true;
        BFS(start);



    }

    private static void DFS(int node){
        System.out.print(node+" ");
        for(int n : A[node]){
            if(!visited[n]) {
                visited[n] = true;
                DFS(n);
            }
        }
    }

    private static void BFS(int node){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(node);
        System.out.print(node+" ");
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int n : A[now]){
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                    System.out.print(n+" ");
                }
            }
        }
    }
}
