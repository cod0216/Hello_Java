package TIL;

import java.util.*;
import java.io.*;

public class J1300 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(buffer.readLine());
        int key = Integer.parseInt(buffer.readLine());
        int num=0;
        int[] value = new int[index*index+0];
        for(int i = 0; i < index; i++){
            for(int j = 0; j< index; j++){
                value[num++] = (i+1)*(j+1);
            }
        }
        Arrays.sort(value);
        System.out.println(value[key-1]);

    }
}
