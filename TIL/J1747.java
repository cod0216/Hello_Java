package TIL;

import java.io.*;
import java.util.*;

public class J1747 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int key = Integer.parseInt(buffer.readLine());

        int[] array = new int[1_100_000+1];

        for(int i = 0; i<=1100000; i++){
            array[i] = i;
        }
        array[1]=0;

        for(int i=2; i<Math.sqrt(1100000); i++){
            if(array[i] == 0) continue;
            for(int j=i+i; j<=1100000; j=j+i){
                array[j] = 0;
            }
        }

        for(int i = key; i<= 1100000; i++){
            if(array[i] != 0 && check(array[i])) {
                System.out.println(array[i]);
                break;
            }
        }
    }

    public static boolean check(int value){
        String str = Integer.toString(value);
        char[] array = str.toCharArray();
        int cnt = str.length();

        for(int i =0; i < cnt/2; i++){
            if(array[i] != array[cnt-i-1]) return false;

        }
        return true;
    }
}
