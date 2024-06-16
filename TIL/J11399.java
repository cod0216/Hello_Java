package TIL;

import java.io.*;
import java.util.*;


public class J11399 {
    static int[] result;
    static int max;
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(buffer.readLine());

        int[] arr = new int[num];
        result = new int[num];

        String[] input = buffer.readLine().split(" ");

        for(int i =0; i < arr.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        int first = arr[0];
        max = first;
        result[0] = first;

        for(int i =1; i< arr.length; i++){
            int index = sort(i, arr[i]);
            shift(index, i);
            result[index] =arr[i];
        }

        int[] sum = new int[num];
        int total = 0;

        for(int i = 0; i< result.length; i++){
            total += result[i];
            sum[i] += total;
        }
        total = 0;
        for(int i = 0; i< result.length; i++){
            total+= sum[i];
        }
        System.out.println(total);
    }

    public static void shift(int start, int end){
        for(int i = end; i > start; i--) {
            int temp = result[i - 1];
            result[i - 1] = result[i];
            result[i] = temp;
        }
    }

    public static int sort(int index, int key){
        boolean toggle = false;
        if (max <= key){
            max = key;
            return index;
        }

        for(int i=index-1; i >=0; i--){
            if(result[i]<=key){
                if(result[i+1] != 0) return i+1;
            }

            if(result[i]>key)
                toggle = true;
        }
        if(toggle)
            return 0;
        else return index;
    }
}
