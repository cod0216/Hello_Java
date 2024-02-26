package TIL;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J11724 {
    static boolean visited[];
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    String[] input = bufferedReader.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    visited = new boolean[n+1];
    A = new ArrayList[n+1];

    for(int i = 1; i <= n; i++){
        A[i] = new ArrayList<Integer>();
    }
    for(int i=0; i<m; i++){
        input = bufferedReader.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        A[s].add(e);
        A[e].add(s);
    }
    int count = 0;
    for(int i = 1; i <=n; i++){
        if(!visited[i]) {
            count++;
            DFS(i);
        }
    }
    System.out.println(count);

    }
    public static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true;

        for(int i : A[v]){
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
