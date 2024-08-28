package TIL;

import java.io.*;
import java.util.*;

public class J2252_2 {
    static LinkedList<Integer>[] list;
    static int[] arr;
    static int[] result;
    static int fIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        list = new LinkedList[n+1];

        for(int i = 0 ; i < n+1 ; i ++ ) {
            list[i] = new LinkedList<Integer>();
        }
        arr = new int[n+1];
        result = new int[n+1];
        int index = 0 ;
        for(int i = 0; i < m; i++){
            input  = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            list[node].add(edge);
            arr[edge]++;
        }

        for(int i = 1; i <= n; i ++){
            if(arr[i] == 0){
                index = i;
                break;
            }
        }

        topology(index);

        for(int i = 0 ;  i< n; i++){
            System.out.print(result[i]+ " ");
        }
        System.out.println();
    }

    public static void topology(int idx){

        for(int edge : list[idx]){
            arr[edge]--;
            if(arr[edge] == 0){
                System.out.println("확인");
                result[fIndex++] = edge;
                topology(edge);
            }
        }
    }
}
