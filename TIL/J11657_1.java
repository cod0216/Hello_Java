package TIL;

import java.io.*;
import java.util.*;

public class J11657_1 {
    static int n, m;
    static ArrayList<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input[] = buffer.readLine().split(" ");

         n = Integer.parseInt(input[0]);
         m = Integer.parseInt(input[1]);
         list = new ArrayList[m];

         long[] arr1 = new long[n];
         long[] arr2 = new long[n];

         for(int i = 0; i < n; i++){
             arr1[i] = 9999999;
             arr2[i] = 9999999;
         }

        arr1[0] = 0;
        arr2[0] = 0;



         for(int i = 0; i < m; i++){
             list[i] = new ArrayList<>();
             input = buffer.readLine().split(" ");

             int a = Integer.parseInt(input[0]);
             int b = Integer.parseInt(input[1]);
             int c = Integer.parseInt(input[2]);

             list[i].add(new int[]{a,b,c});
         }

         for(int i = 0; i < n-1; i++){
             arr1 = bellman(arr1);
         }

        for(int i = 0; i < n; i++){
            arr2= bellman(arr2);
        }

        for(int i = 1; i< n; i++){
            if(arr1[i] != arr2[i]){
                System.out.println("-1");
                return;
            }
        }

        for(int i = 1; i< n; i++){
            if(arr1[i] == 9999999) System.out.println("-1");
            else System.out.println(arr1[i]);
        }
    }

    public static long[] bellman(long[] arr){

        for(int i = 0 ; i< m; i++){
            int[]  node = list[i].get(0);
            int start = node[0]-1;

            if(arr[start] == 9999999) continue;
            int end = node[1] - 1;
            int w = node[2];
            arr[end] = Math.min(arr[start]+w,arr[end]);
        }
        return arr;
    }
}
