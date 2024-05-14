package TIL;

import java.util.*;
import java.io.*;

public class J2252_0 {
    static LinkedList<Integer>[] A;
    static int[] array;
    static boolean[] visited;
    static int E;
    static int N;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        array = new int[N+1];
        A = new LinkedList[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            A[i] = new LinkedList<>();
        }

        for(int i = 0; i<E; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end =  Integer.parseInt(input[1]);
            A[start].add(end);
            array[end]++;
        }
        int node = 0;
        for(int i = 1; i<= E; i++){
            if(array[i] == 0){
                node = i;
                break;
            }
        }

        phase();
    }

    public static void phase(){
        int k = 0;
        while(k <N){
            for(int i = 1; i<= N; i++){
                if (array[i] == 0 && !visited[i]) {
                    visited[i] = true;
                    int now = i;
                    System.out.print(now + " ");
                    for (int j : A[now]) {
                        array[j]--;
                    }
                }
            }
                k++;
        }
    }
}
