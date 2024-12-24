package TIL;

import java.io.*;
import java.util.*;

public class J11659_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input= buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] arr = new int[n+1];
        input = buffer.readLine().split(" ");

        for(int i= 0; i <n; i++){
            arr[i+1] = arr[i] + Integer.parseInt(input[i]);
        }

        for(int i= 0; i <m; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            System.out.println(arr[end]-arr[start-1]);
        }
    }
}
