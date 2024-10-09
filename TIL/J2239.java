package TIL;


import java.io.*;
import java.util.*;

public class J2239 {
    static int map[][] = new int[9][9];
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input;


         for(int i = 0; i < 9; i++){
             input = buffer.readLine().split("");
             for(int j = 0 ; j < 9; j++){
                 map[i][j] = Integer.parseInt(input[j]);
                 if(map[i][j] == 0) list.add(new int[]{i,j});
             }
         } //입력 완료

        sudoku(0);


    }

    public static void sudoku(int depth){
        if(depth == list.size()){
            for(int i = 0; i< 9; i++){
                for(int j = 0; j< 9; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }


        int[] cur = list.get(depth);
        int x = cur[0]; int y = cur[1];

        for(int i = 1 ; i<= 9; i++){
            if(findNum(i,x,y)) {
                map[x][y] = i;
                sudoku(depth + 1);
                map[x][y] = 0;
            } //backtracking
        }

    }
    public static boolean findNum(int num, int x, int y){
        for(int i = 0 ; i <9; i++){
            if(map[x][i] == num)return false;
            if(map[i][y] == num)return false;
        } // line check

        int startX = x/3 *3; int endX = startX+3;
        int startY = y/3 *3; int endY = startY+3;

        for(int i = startX; i<endX; i++){
            for(int j = startY; j<endY; j++) {
                if(map[i][j] == num) return false;
            }
        } // block check

        return true;
    }
}
