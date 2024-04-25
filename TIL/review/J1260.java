package TIL.review;

import java.util.*;
import java.io.*;
public class J1260 {
static LinkedList<Integer>[] A;
static boolean[] visited;
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader((new InputStreamReader(System.in)));

         String[] input = buffer.readLine().split(" ");

         int node = Integer.parseInt(input[0]);
         int edge = Integer.parseInt(input[1]);
         int startNode = Integer.parseInt(input[2]);
         A = new LinkedList[node+1];
         visited = new boolean[node+1];
         for(int i = 0; i <= node; i++){
             A[i] = new LinkedList<>();
         }

        for(int i = 0; i < edge; i ++){
            input = buffer.readLine().split(" ");
            int newNode = Integer.parseInt(input[0]);
            int newEdge = Integer.parseInt(input[1]);

            A[newNode].add(newEdge);
            A[newEdge].add(newNode);

        }
        for(int i = 0; i <= node; i ++) {
            Collections.sort(A[i]);
        }

        DFS(startNode);
        visited = new boolean[node+1];
        System.out.println();
        BFS(startNode);

    }

    public static void DFS(int node){
        visited[node] = true;
        System.out.print( node + " ");
        for(int i : A[node]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
    public static void BFS(int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()){
            int now = queue.poll();
            System.out.print( now + " ");
            for(int i : A[now]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);

                }
            }

        }
    }

}
