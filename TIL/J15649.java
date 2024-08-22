package TIL;

import java.io.*;
import java.util.*;

public class J15649 {

    static int[] arr;
    static int x;
    static int y;
    static boolean[] visited;
    static int[] dummy;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");


        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);

        arr = new int[x];
        visited=new boolean[x];
        dummy = new int[y];

        for(int i = 1; i <= x; i++){
            arr[i-1] = i;
        }
        combination(0);
    }

    public static void combination(int cnt){
        if(cnt >= y){
            for(int i = 0 ; i < y; i++) {
                System.out.print(dummy[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0 ; i < x; i++){
            if(!visited[i]){
                visited[i]=true;
                dummy[cnt] = arr[i];
                combination(cnt+1);
                visited[i]=false;
            }
        }
    }
}
