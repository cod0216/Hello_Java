package TIL;


import java.io.*;
import java.util.*;

public class J10974 {
    static int[] arr;
    static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(buffer.readLine());

        arr = new int[n];


        for(int i = 0; i < n; i ++){
            arr[i] = i+1;
        }
        int[] value = new int[n];
        boolean[] visited = new boolean[n];
        DFS(value,0,n,visited);
        System.out.println(builder.toString());


    }
    public static void DFS(int[] num, int start, int end, boolean[] visited){
        if(start == end){
            for(int i =0; i< end; i++)
                builder.append(num[i] + " ");
            builder.append("\n");
            return;
        }
        for(int i = 0; i<end; i++) {
            if(!visited[i]) {
                visited[i] = true;
                num[start] = arr[i];
                DFS(num,start+1, end, visited);
                visited[i] = false;
            }
        }
    }
}
