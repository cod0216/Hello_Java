package TIL;


import java.io.*;
import java.util.*;

public class S1954 {
    static int[][]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t) {
            int n = Integer.parseInt(buffer.readLine());

            arr = new int[n][n];

            int print = n;
            int bottom = 0;
            int right = -1;
            int top = 1;
            int k = 1;
            int d = 1;


            for (int i = 0; i < n; i++) {
                for (int j = 0; j < print; j++) {
                    right += top;
                    arr[bottom][right] = d++;
                    k++;
                }
                print--;
                for (int j = 0; j < print; j++) {
                    bottom += top;
                    arr[bottom][right] = d++;;
                    k++;
                }
                top *= -1;
                System.out.println();
            }




            t++;
            System.out.println("#"+t);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(arr[i][j]+ " ");
                }
                System.out.println();
            }
        }


    }
}
