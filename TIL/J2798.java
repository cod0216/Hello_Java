package TIL;

import java.io.*;
import java.util.*;

public class J2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split( " ");

        int card = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);
        int[] array = new int[card];

        input = buffer.readLine().split( " ");

        for(int i = 0; i< card; i++){
            array[i] =  Integer.parseInt(input[i]);
        }
        Arrays.sort(array);
        int max = 0;

        for(int i = 0; i < card-2; i++){
            for(int j = i+1; j< card-1; j++){
                for(int k = j+1; k< card; k++){
                    int value = array[i]+array[j]+array[k];
                    if(value <= key && max < value) {
                            max = value;
                    }
                }
            }
        }
        System.out.println(max);

    }
}
