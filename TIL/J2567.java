package TIL;

import java.io.*;
import java.util.*;


public class J2567 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(buffer.readLine());
        int[][] array = new int[102][102];


        for(int i =0; i< num; i++){
            String[] input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            for(int j = x; j < x+10; j++){
                for(int k = y; k < y+10; k++){
                    array[j][k] = 1;
                }
            }
        }
        int cnt =0;
        for(int i = 1; i < 102; i++){
            for(int j = 1; j < 102; j++){
                    if(array[i][j] ==1){
                        if(array[i][j+1] == 0) cnt++;
                        if(array[i][j-1] == 0) cnt++;
                        if(array[i+1][j] == 0) cnt++;
                        if(array[i-1][j] == 0) cnt++;
                    }
            }
        }
        System.out.println(cnt);
    }
}
