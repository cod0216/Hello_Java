package TIL;

import java.io.*;
import java.util.*;


public class SWEA1961 {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());

        int[][] arr1 = new int[N][N];
        int[][] arr2 = new int[N][N];
        int[][] arr3 = new int[N][N];


        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr1[i][j] = Integer.parseInt(input[j]);
            }
        }
        changeArr(arr1,arr2);
        changeArr(arr2,arr3);
        changeArr(arr3,arr1);

        for(int i =0; i<N; i++){
            for (int j = 0; j < N; j++)
                System.out.print(arr2[i][j]);
            System.out.print(" ");
            for (int j = 0; j < N; j++)
                System.out.print(arr3[i][j]);
            System.out.print(" ");
            for (int j = 0; j < N; j++)
                System.out.print(arr1[i][j]);
            System.out.println();
            }
        }


    public static void changeArr(int[][] arr1, int[][] arr2){
        for(int i = 0; i< arr1.length; i++){
            for(int j = arr1.length-1; j>= 0; j--) {
                arr2[i][arr2.length-1-j]= arr1[j][i];
            }
        }

    }
}
