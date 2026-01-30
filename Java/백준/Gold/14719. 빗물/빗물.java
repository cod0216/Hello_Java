import java.util.*;
import java.io.*;

public class Main {
    static int N, M, arr[], total;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = new int[M];
        input = buffer.readLine().split(" ");
        int max = 0;
        int mid = 0;
        for(int i = 0 ; i < M; i++){
            arr[i] = Integer.parseInt(input[i]);
            if(max < arr[i]){
                mid = i;
                max = arr[i];
            }
        }
        for(int i = 1; i < M-1; i++){
            int left = checkLeft(i);
            int right = checkRight(i);            
            int water = Math.min(left, right) - arr[i];
            if(water > 0) total += water;
        }

        System.out.println(total);
    }
    public static int checkLeft(int base){
        int left = 0;
        for(int i = 0; i < base; i++){
            left = Math.max(left,arr[i]);
        }
        return left;
    }
    public static int checkRight(int base){
        int right = 0;
        for(int i = base+1; i < M; i++){
            right = Math.max(right, arr[i]);
        }        
        return right;
    }
}
