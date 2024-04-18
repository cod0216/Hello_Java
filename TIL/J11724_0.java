package TIL;

import java.util.*;
import java.io.*;




public class J11724_0 {

    static LinkedList<Integer>[] A;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        visited = new boolean[node+1];
        A = new LinkedList[node+1];
        for (int i = 0 ; i < node+1; i++){
            A[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge; i++){
            input = buffer.readLine().split(" ");
            int startNode = Integer.parseInt(input[0]);
            int endNode = Integer.parseInt(input[1]);

            A[startNode].add(endNode);
            A[endNode].add(startNode);
        }
        for (int i = 1 ; i < node+1; i++) {
            if(!visited[i]){
                DFS(i);
                count++;
            }
        }

            System.out.println(count);

    }
    public static void DFS(int node){
        if (visited[node]){
//            count++;
        }

        else {
            visited[node] = true;
            for(int i : A[node]) DFS(i);
        }
    }
}
