import java.util.*;
import java.io.*;

public class J13023_2 {
    static LinkedList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");



        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        list = new LinkedList[n+1];

        for(int i = 0; i< n+1; i++) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0 ; i <m; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            list[end].add(start);
        }

        for(int i = 0; i < n; i++) {
            visited = new boolean[n+1];
            DFS(i,0);
        }

        System.out.println("0");

    }
    public static void DFS(int node, int depth) {
        visited[node] = true;
        if(depth ==4) {
            System.out.println("1");
            System.exit(0);
        }

        for(int i : list[node]) {
            if(!visited[i]) {
                DFS(i, depth+1);
            }
        }
        visited[node] = false;

    }
}