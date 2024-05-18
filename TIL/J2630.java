package TIL;

import java.util.*;
import java.io.*;
public class J2630 {
    static int cntBlack = 0;
    static int cntWhite = 0;
    static int[][] array;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(buffer.readLine());
        array = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                array[i][j] = Integer.parseInt(input[j]);
            }
        }
        cut(0,0,size);
        System.out.println(cntWhite);
        System.out.println(cntBlack);
    }
    public static void cut(int x, int y, int size){
        int sum = 0;

        for(int i = x; i < x+size; i++){
            for(int j = y; j< y+size; j++) {
                if(array[i][j] == 1) sum++;
            }
        }

        if(sum == 0) cntWhite++;
        else if(sum == size*size) cntBlack++;
        else{
            cut(x, y,size/2);
            cut(x, y+size/2,size/2);
            cut(x+size/2, y,size/2);
            cut(x+size/2,y+size/2,size/2);
        }
    }
}
