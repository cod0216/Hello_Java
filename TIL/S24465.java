package TIL;

import java.io.*;
import java.util.*;

public class S24465 {
    public static BufferedReader buffer;
    public static int T;
    public static void buffer() throws IOException{
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void initCase() throws IOException {
        T = Integer.parseInt(buffer.readLine());
    }

    public static void solve(int T) throws IOException {
        int t = 0;
        while(T>t){
            int n = Integer.parseInt(buffer.readLine());
            String[] input = buffer.readLine().split(" ");
            System.out.println(process(n, input));
            t++;
        }
    }
    public static int process(int n, String[] input) {
        int[] x = new int[n];
        for (int i = 0; i <n; i++) {
            x[i] = Integer.parseInt(input[i]);
        }

        int totalSum = 0;
        for (int i = 1; i < n; i++) {
            totalSum += Math.abs(x[i] - x[i-1]);
        }

        int max = 0;
        for (int i = 1; i < n-1; i++) {
            int a = Math.abs(x[i] - x[i-1]);
            int b = Math.abs(x[i+1] - x[i]);
            int c = Math.abs(x[i+1] - x[i-1]);
            int diff = a+b-c;
            if(max<diff) max = diff;
        }

        return totalSum-max;
    }

    public static void main(String[] args) throws IOException {
        buffer();
        initCase();
        solve(T);
    }
}
