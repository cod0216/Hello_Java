package TIL;

import java.io.*;
import java.util.*;


public class J1033 {
static LinkedList<Integer>[] A;
static boolean[] visited;
static int[] values;
static int node;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        node = Integer.parseInt(buffer.readLine());
        A = new LinkedList[node+1];
        for(int i = 0; i<= node; i++){
            A[i] = new LinkedList<>();
        }
        values = new int[node+1];
        visited = new boolean[node+1];

        for(int i =0; i<= node; i++){
            values[i] = 1;
        }
        for(int i = 1; i<node; i++){
            String[] input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
            int q = Integer.parseInt(input[3]);

            int min = Math.min(p,q);
            int max = Math.max(p,q);

            int gcd = gcd(max, min);

            p = p/gcd;
            q = q/gcd;

            if(values[b] != 1 || values[a] != 1){
                int valuesA;
                int valuesB;

                valuesA = values[b]*p;
                valuesB = values[a]*q;

                max = Math.max(valuesA, valuesB);
                min = Math.min(valuesA, valuesB);

                gcd = gcd(max, min);

                valuesA = valuesA/gcd;
                valuesB = valuesB/gcd;

                values[a] = values[a]*valuesA;
                values[b] = values[b]*valuesB;

                DFS(a,valuesA);
                visited = new boolean[node+1];
                DFS(b,valuesB);
                visited = new boolean[node+1];
            }else {
                values[a] = values[a]*p;
                values[b] = values[b]*q;

                DFS(a,p);
                visited = new boolean[node+1];
                DFS(b,q);
                visited = new boolean[node+1];
            }
            A[a].add(b);
            A[b].add(a);
        }
        for(int i = 0; i<node; i++){
            System.out.print(values[i]+" ");
        }
    }

    public static void DFS(int node, int value){
        visited[node] = true;
        for(int i : A[node]){
            if(!visited[i]){
                values[i] = values[i]*value;
                DFS(i, value);
            }
        }
    }
    public static int gcd(int max, int min){
        if(min == 0) return max;
        return gcd(min, max%min);
    }
}
