package TIL;

import java.io.*;
import java.util.*;


public class J3085 {
    static char[][] array;
    static int num;
    static int max = 0;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(buffer.readLine());

        array = new char[num][num];

        for(int i = 0 ; i < num; i++){
            array[i]= buffer.readLine().toCharArray();
        }
        for(int i = 0; i < num-1; i++) {
            findCol(i);
            findRow(i);
        }

        for(int i = 0; i < num; i++){
            for(int j = 0; j<num-1; j++){
                char temp = array[i][j];
                array[i][j] = array[i][j+1];
                array[i][j+1] = temp;
                findRow(i);
                findCol(j);
                findCol(j+1);
                temp = array[i][j];
                array[i][j] = array[i][j+1];
                array[i][j+1] = temp;
            }
        }

        for(int i = 0; i < num; i++){
            for(int j = 0; j<num-1; j++){
                char temp = array[j][i];
                array[j][i] = array[j+1][i];
                array[j+1][i] = temp;
                findRow(j);
                findRow(j+1);
                findCol(i);
                temp = array[j][i];
                array[j][i] = array[j+1][i];
                array[j+1][i] = temp;
            }
        }
        System.out.println(max);
    }

    public static void findRow(int x){
        int cnt = 1;

        for(int i = 0; i < num-1; i++){
            if(array[x][i] == array[x][i+1]) cnt++;
            else cnt = 1;
            if(cnt>max) max = cnt;
        }

    }
    public static void findCol(int y){
        int cnt = 1;

        for(int j = 0; j <num-1; j++){
            if(array[j][y] == array[j+1][y]) cnt++;
            else cnt = 1;
            if(cnt>max) max = cnt;
        }
    }
}
