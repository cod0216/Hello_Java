package TIL;

import java.util.*;
import java.io.*;

public class J1753 {
    static LinkedList<int[]>[] A;
    static boolean[] visited;
    static int[] array;
    static int startNode;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args)throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int E = Integer.parseInt(input[1]);
        A = new LinkedList[N+1];
        visited = new boolean[N+1];
        array = new int[N+1];

        for(int i = 1; i<=N; i++){
            array[i] = 99999999;
        }

        startNode = Integer.parseInt(buffer.readLine());
        array[startNode] = 0;

        for(int i =0; i<=N;i++){
            A[i] = new LinkedList<>();
        }

        for(int i =0; i<E; i++){
            input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            A[node].add(new int[]{edge, weight});
        }
        Dijkstra(startNode);

        for(int i = 1; i<=N; i++){
            if(array[i] == 99999999){
                System.out.println("INF");
            }else{
                System.out.println(array[i]);
            }
        }


    }

    public static void Dijkstra(int node) {
        visited[node] = true;
        for (int[] i : A[node]) {
            if (!visited[i[0]]) {
                array[i[0]] = Math.min(array[node] + i[1], array[i[0]]);
            }
        }
        int min=99999999;
        int index = 0;
        for(int i = 1; i<array.length; i++){
            if(!visited[i]){
                if(array[i]<min ) {
                    min = array[i] ;
                    index = i;
                }
            }
        }
        if(!visited[index]) Dijkstra(index);
    }
}
