package TIL;

import java.io.*;
import java.util.*;

public class J10986 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int index = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);

        long[] array = new long[index];
        long[] cnt = new long[key];
        input = buffer.readLine().split(" ");

        long sum = 0;
        long count = 0;
        long result = 0;

        for(int i = 0; i < index; i++){
            sum += Long.parseLong(input[i]);
            array[i] = sum%key;

            if(array[i] == 0){
                count++;
            }

            cnt[(int)array[i]]++;
        }

        result = count;

        for(int i = 0; i < key; i++){
            if(cnt[i] >1){
                result += (cnt[i]*(cnt[i]-1))/2;
            }
        }

        System.out.println(result);
    }
}
