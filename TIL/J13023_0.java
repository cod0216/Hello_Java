package TIL;


import java.util.*;
import java.io.*;
public class J13023_0 {
    static LinkedList<Integer>[] A;
    static boolean[] visited;
    static int max=5;
    static int good = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        visited = new boolean[node];
        A = new LinkedList[node];

        for(int i = 0; i < node; i++){
            A[i] = new LinkedList<>();
        }

        for(int i = 0; i < edge; i++){
            input = buffer.readLine().split(" ");
            int startNode = Integer.parseInt(input[0]);
            int endNode = Integer.parseInt(input[1]);
            A[startNode].add(endNode);
            A[endNode].add(startNode);
        }
        for(int i = 0; i < node; i++){
            DFS(i,1);
            visited = new boolean[node];
        }

        if(good == 1){
            System.out.println(good);
        }
        else
            System.out.println(good);

    }

    public static void DFS(int node, int cnt){
        visited[node] = true;
        if(cnt == max){
            good = 1;
        }
        else{
            for(int i : A[node]) {
                if(!visited[i]) {
                    DFS(i, cnt + 1);
                }
            }
            visited[node] = false;
        }

    }
}
