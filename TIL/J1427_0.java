package TIL;

import java.io.*;
import java.util.*;

public class J1427_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String str = buffer.readLine();
        int[] n = new int[str.length()];

        for(int j =0; j < str.length(); j++) {
            n[j] = Integer.parseInt(str.substring(j, j + 1));
        }
        int index = 0;

        for(int i = 0 ; i < n.length; i++){
            int min = 0;
            for(int j=i; j <n.length; j++){
                if(min <= n[j]){
                    min = n[j];
                    index = j;
                }
            }
            int temp = n[i];
            n[i] = n[index];
            n[index] = temp;

        }
        for(int i = 0; i < n.length;i++){
            System.out.print(n[i]);
        }
    }
}
