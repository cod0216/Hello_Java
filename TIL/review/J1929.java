package TIL.review;

import java.util.*;
import java.io.*;

public class J1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        int[] array = new int[end + 1];
        for (int i = 0; i < end+1; i++) {
            array[i] = i;
        }

        int key = (int) Math.sqrt(end);
        array[1] = 0;
        for(int i = 0; i<=key; i++){
            if(array[i] == 0) continue;
            for(int j = i+i; j<=end; j=j+i){
                array[j] = 0;
            }
        }

        for(int i = start; i < array.length; i++){
            if(array[i] != 0)
                System.out.println(array[i]);
        }
    }
}
