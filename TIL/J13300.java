package TIL;

import java.io.*;
import java.util.*;


public class J13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] arr = new int[2][7];

        for(int i = 1 ; i<N+1; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int g = Integer.parseInt(input[1]);

            arr[s][g]++;
        }
        int cnt = 0;
        int room = 0;
        for(int i = 1; i <= N; i++){
            cnt += arr[0][i]
        }
        System.out.println(room);
    }
}
