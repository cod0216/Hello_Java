package TIL;

import java.io.*;

public class J11404 {
    static int[][] array;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int city = Integer.parseInt(buffer.readLine());
        int n = Integer.parseInt(buffer.readLine());
        array = new int[city+1][city+1];

        for(int i = 1; i<= city; i++) {
            for (int j = 1; j <= city; j++) {
                if(i == j) array[i][j] = 0;
                else array[i][j] = 9999999;
            }
        }


        for(int i = 1; i <= n; i++){
            String input [] = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            array[start][end] = Math.min(array[start][end], weight);
        }


        for(int k = 1; k<= city; k++){
            for(int s = 1; s<= city; s++){
                for(int e = 1; e<= city; e++){
                    array[s][e] = Math.min(array[s][e], array[s][k]+array[k][e]);
                }
            }
        }

        for(int i = 1; i<= city; i++) {
            for (int j = 1; j <= city; j++) {
                if (array[i][j] == 9999999) System.out.print("0" + " ");
                else System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
