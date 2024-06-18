package TIL;

import java.io.*;
import java.util.*;

public class J11004 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);
        arr = new int[num];
        input = buffer.readLine().split(" ");

        for (int i = 0; i < num; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        quickSort(0, num-1);

        System.out.println(arr[key]);
    }

    public static void quickSort(int start, int end){
        if(start == end){
            return;
        }
        end = end-1;
        int pivot = arr[end];
        while(start <= end) {
            if (arr[start] < pivot)
                start++;
            if (arr[end] > pivot)
                end--;
            if(arr[start] >pivot && arr[end] < pivot){
                swap(start, end);
            }
            if(start == end){
                if(arr[start]< pivot){
                    Shift(start-1);
                    arr[start-1] = pivot;
                }else{
                    Shift(start+1);
                    arr[start+1] = pivot;
                }
            }

        }
        if (start == end) {
            quickSort(0,start);
            quickSort(start+1,end);
        }


    }
    public static void Shift(int index){
        for(int i = arr.length; i> index; i++){
            arr[i] = arr[i-1];
        }
    }
    public static void swap(int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
