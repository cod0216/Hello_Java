package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J22862 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];

        input = buffer.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        int m = 0;

        while(N>right){

            if(arr[right] % 2 == 0) {
                right++;
            } else {
                if(M>m){
                    m++;
                    right++;
                } else {
                    if(arr[left] % 2 == 1) m--;
                    left++;
                }
            }
            max = Math.max(max,right - left - m);
        }

        System.out.println(max);
    }
}
