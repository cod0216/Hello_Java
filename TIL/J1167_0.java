package TIL;

import java.util.*;
import java.io.*;

public class J1167_0 {
    static LinkedList<int[]>[] A;
    static Boolean[] visited;

    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int Num = Integer.parseInt(bufferedReader.readLine());

        visited = new Boolean[Num +1];
        A = new LinkedList[Num+1];

        for(int i =0; i<Num+1; i++){
            A[i] = new LinkedList<int[]>();
        }

        for(int i = 0; i<Num; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int cnt = 1;
            while(Integer.parseInt(input[cnt]) != -1) {
                int edge = Integer.parseInt(input[cnt]);
                cnt++;
                int edgeLength = Integer.parseInt(input[cnt]);
                cnt++;
                A[node].add(new int[]{edge, edgeLength});
            }
        }

    }
//    private static void BFS(int node){
//
//        Queue<int[]> queue = new LinkedList<int[]>();
//        visited[node] = true;
//        queue.add(A[node]);
//
//        while(!queue.isEmpty()){
//            int value = queue.poll();
//
//        }
//    }
}
