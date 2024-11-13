package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1913 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        int key  = Integer.parseInt(buffer.readLine());

        int[][] map = new int[n][n];

        int print = n;
        int leftRight = 0;
        int topBottom = -1;
        int go = 1;
        int write = n*n;


        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < print; j++){
                topBottom += go;
                map[topBottom][leftRight] = write--;
            }
            print--;

            for(int j = 0 ; j < print; j++){
                leftRight += go;
                map[topBottom][leftRight] = write--;
            }
            go*=-1;
        }

        for(int i= 0 ; i< n; i++){
            for(int j= 0 ; j< n; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        for(int i= 0 ; i< n; i++){
            for(int j= 0 ; j< n; j++){
                if(map[i][j] == key)
                System.out.println( (i+1) + " " + (j+1));
            }
        }
    }
}
