package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1507 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0 ; i < n; i++){
            String[] input = buffer.readLine().split(" ");
            for(int j = 0 ; j < n; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }


    }
}
