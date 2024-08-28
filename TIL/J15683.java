package TIL;

/*

CCTV 1  CCTV 2   CCTV 3   CCTV 4    CCTV 5
                    |        |         |
  o->    <-o->      o->    <-o->     <-o->
                                       |
6번은 벽

CCTV는 회전 시킬 수 있다. 회전은 항상 90도 방향으로 해야한다.
감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
 */


import java.io.*;
import java.util.*;

public class J15683 {
    static int[][] arr;
    static int N;
    static int M;

    static boolean[][] visited;

    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int R = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        arr = new int[R][C];

        for(int i = 0; i< R; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j < C; j++){
                arr[i][j]= Integer.parseInt(input[j]);
            }
        }



    }

}
