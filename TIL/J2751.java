package TIL;

import java.util.*;
import java.io.*;

public class J2751 {
    public static void main(String args[]) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(buffer.readLine());
        int[] arr = new int[num];

        for(int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(buffer.readLine());
        }


        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i+"\n");

        }
        System.out.println(sb);


    }
}
