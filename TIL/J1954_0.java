package TIL;

import java.io.*;

public class J1954_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        int[][] arr = new int[n][n];

        int size = n;
        int upDown = 0;
        int rightLeft = -1;
        int go = 1;
        int write = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j<size; j++){
                rightLeft += go;
                arr[upDown][rightLeft] = write++;
            }
            size--;
            for(int j = 0; j<size; j++){
                upDown += go;
                arr[upDown][rightLeft] = write++;
            }
            go *= -1;
        }

        for (int i = 0; i < n; i++){
            for(int j = 0; j <n; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
