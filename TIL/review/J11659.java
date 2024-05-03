package TIL.review;

import java.util.*;
import java.io.*;

public class J11659 {
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int index = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        int[] array = new int[index];
        int[] array1 = new int[index+1];

        input = buffer.readLine().split(" ");
        int sum = 0;

        for (int i =0; i<index; i++){
            array[i] = Integer.parseInt(input[i]);
            sum += array[i];
            array1[i+1] = sum;
        }

        for(int i=0; i<n; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0])-1;
            int end = Integer.parseInt(input[1]);
            int result = array1[end] - array1[start];
            System.out.println(result);
        }

    }
}
