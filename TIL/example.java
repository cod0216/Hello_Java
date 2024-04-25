package TIL;

import java.io.*;
import java.util.*;

public class example {
    public static void main(String[] args) throws IOException {
        char[][] array = new char[8][8];

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        char[] window = new char[n];

        String input = buffer.readLine();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j< 8; j++){
                array[i] = input.toCharArray();
            }
        }

        for(int i = 0; i < n; i++){
            window[i] = array[0][i];
        }
        int index = 0;
        while(index != 8){
            int start = 0;
            int end = n-1;
            if (window[start] == window[end]){

            }



        }







    }
}
