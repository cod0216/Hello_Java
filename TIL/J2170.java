package TIL;

import java.io.*;
import java.util.*;

public class J2170 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] input = buffer.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);

        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            else{
                return o1[0]-o2[0];
            }
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int res = end - start;

        for (int i = 1; i < n; i++) {
            if(start <= arr[i][0] && arr[i][1] <= end) continue;
            else if(end > arr[i][0]) res += arr[i][1]-end;
            else res += arr[i][1] - arr[i][0];
            start = arr[i][0];
            end = arr[i][1];
        }
        System.out.println(res);




    }
}



