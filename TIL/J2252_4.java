package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J2252_4 {
    static ArrayList<Integer>[] list;
    static int[] arr;
    static int N;
    static int M;
    static int node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N+1];
        list = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i = 0 ; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        int node = 0;
        for(int i = 0 ; i < M; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            arr[end]++;

        }

        topology();




    }

    private static void topology() {

        int k = 0;
        while(k<N ){
            for(int i = 1; i <= N; i++){
                if(arr[i] == 0 && !visited[i]){
                    visited[i] = true;
                    System.out.print(i + " ");
                    for(int node : list[i]){
                        arr[node]--;
                    }
                }
            }
            k++;
        }
    }
}
