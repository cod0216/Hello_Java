package TIL;

import java.util.*;
import java.io.*;

import static java.lang.System.exit;

public class J13023 {
    static LinkedList<Integer>[] A;

    static int n, e;
    public static void main(String[] args)throws IOException{

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        A = new LinkedList[n];
        for(int i = 0; i < n; i++){
            A[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i <e; i++){
            input = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            A[a].add(b);
            A[b].add(a);
        }

        for(int i = 0 ; i <n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            DFS(i, 1, visited);
        }

        System.out.println(0);
    }

    private static void DFS(int num, int cnt, boolean[] visited){

        if(cnt == 5){
            System.out.println(1);
            exit(0);
        }
        visited[num] = true;
        for(int i : A[num]) {
            if (!visited[i]) {
                DFS(i, cnt + 1, visited);
            }
        }
        visited[num] = false;
    }
}
