package TIL;

import java.io.*;

public class J11004_1 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int num = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);

        int[] arr = new int[num];

        input = buffer.readLine().split(" ");

        for(int i = 0; i < num; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        quickSort(arr, 0, arr.length-1);
        System.out.println(arr[key-1]);

    }

    public static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);
        if(start < part2-1){
            quickSort(arr, start, part2-1);
        }
        if(part2 < end){
            quickSort(arr, part2, end);
        }
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while(start <= end){
            while(arr[start] < pivot) start++;
            while(arr[end] > pivot) end--;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}


