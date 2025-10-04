package TIL;

import java.util.*;
import java.io.*;

public class J1561 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        long N = Long.parseLong(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] arr = new int[M];
        input = buffer.readLine().split(" ");

        for(int i = 0; i < M; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        if(N <= M){
            System.out.println(N);
            return;
        }

        long start = 0;
        long end = N * 30;
        long key = 0;
        while(start <= end){
            long mid = (start + end) / 2;
            long num = M;
            for(int i = 0 ; i < M; i++){
                num += mid / arr[i];
            }

            if(num < N) {
                start = mid + 1;
            } else {
                end = mid - 1;
                key = mid;
            }
        }

        long ans = M;
        for(int i = 0 ; i < M; i++){
            ans += (key-1) / arr[i];
        }

        for(int i = 0 ; i < M; i++){
            if(key % arr[i] == 0){
                ans++;

                if(ans == N) {
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
}
