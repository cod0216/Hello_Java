package TIL;
import java.io.*;
import java.util.*;

public class J2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int[] arr = new int[n];
        Deque<Integer> A = new ArrayDeque<>();
        String[] input = buffer.readLine().split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i ++){
            arr[i]= Integer.parseInt(input[i]);
        }
        A.push(n-1);



        for(int i = n-2; i>=0; i--){
            while(!A.isEmpty() && arr[A.peek()] < arr[i]){
                arr[A.pop()] = i+1;
            }
            A.push(i);
        }

        while (!A.isEmpty()) {
            arr[A.pop()] = 0;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

