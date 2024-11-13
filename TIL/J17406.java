package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class J17406 {
    static int r, c, f, map[][], min;
    static ArrayList<int[]> list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

         r = Integer.parseInt(input[0]);
         c = Integer.parseInt(input[1]);
         f = Integer.parseInt(input[2]);
         visited = new boolean[f];
         map = new int[r][c];
         for(int i = 0; i < r; i++){
             input = buffer.readLine().split(" ");
             for(int j = 0; j < c; j++){
                 map[i][j] = Integer.parseInt(input[j]);
             }
         }

        list = new ArrayList<>();
        for(int i = 0; i < f; i++) {
             input = buffer.readLine().split(" ");
             int a = Integer.parseInt(input[0]);
             int b = Integer.parseInt(input[1]);
             int c = Integer.parseInt(input[2]);
            list.add(new int[]{a, b, c});
         }
        min = Integer.MAX_VALUE;
        p(0, new int[f][3]);




        System.out.println(min);
    }
    public static void p(int depth, int[][] A){
        if(depth == f){
            int[][] temp = clone(map);
            for(int i = 0; i< f; i++){
                pingPing(A[i][0],A[i][1],A[i][2], temp);
            }
            for(int i = 0 ; i < r; i++){
                int sum = 0;
                for(int j = 0 ; j < c; j++){
                    sum += temp[i][j];
                }
                min = Math.min(min,sum);
            }
            return;
        }

        for(int i = 0; i <f; i++){
            if(!visited[i]){
                A[depth] = list.get(i);
                visited[i] = true;
                p(depth+1, A);
                visited[i] = false;
            }
        }
    }
    public static void pingPing(int a, int b, int c, int[][] M) {
        int startX = a - c - 1;
        int startY = b - c - 1;
        int endX = a + c - 1;
        int endY = b + c - 1;

        while (startX < endX && startY < endY) {
            int temp = M[startX][startY];

            for (int i = startX; i < endX; i++) {
                M[i][startY] = M[i + 1][startY];
            }

            for (int i = startY; i < endY; i++) {
                M[endX][i] = M[endX][i + 1];
            }

            for (int i = endX; i > startX; i--) {
                M[i][endY] = M[i - 1][endY];
            }

            for (int i = endY; i > startY + 1; i--) {
                M[startX][i] = M[startX][i - 1];
            }

            M[startX][startY + 1] = temp;

            startX++;
            startY++;
            endX--;
            endY--;
        } //while end
    }

    public static int[][] clone(int[][] origin){
        int[][] copy = new int[r][c];
        for(int i =0 ; i< r; i++){
            for(int j =0 ; j< c; j++){
                 copy[i][j] = origin[i][j];
            }
        }
        return copy;
    }

}
