package TIL;

import java.util.*;
import java.io.*;
public class J1176 {
    static LinkedList<int[]>[] A;
    static boolean[] visited;
    static int max =0;
    static int[][] S;
    static int superNode;
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int node = scanner.nextInt();
        A = new LinkedList[node+1];
        for(int i = 1; i <= node; i++ ){
            A[i] = new LinkedList<>();
        }

        for(int i = 1; i <= node; i++ ) {
            int n = scanner.nextInt();

            while (true) {
                int e = scanner.nextInt();
                if (e == -1)
                    break;
                int length = scanner.nextInt();
                int[] edge = new int[]{e, length};
                A[n].add(edge);
            }
        }
        S = new int[node+1][2];
        visited = new boolean[node+1];
        DFS(1, 0);
        visited = new boolean[node+1];
        DFS(superNode, 0);
        System.out.println(max);
    }
    public static void DFS(int node, int len){
        visited[node] = true;
        S[node][1] = len;
        if(max <len){
            max = len;
            superNode = node;
        }
        for(int[] i : A[node]){
            if(!visited[i[0]])
                DFS(i[0],len+i[1]);
        }
    }
}
