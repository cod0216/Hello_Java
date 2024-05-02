package TIL;

import java.util.*;
import java.io.*;

public class J1541_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String str = buffer.readLine();
        String[] input = str.split("\\-");
        int index = input.length;

        int[] sum = new int[index];
        for(int i = 0; i <index; i++ ){
            String[] plusInput = input[i].split("\\+");
            for(int j = 0; j< plusInput.length; j++)
            sum[i] += Integer.parseInt(plusInput[j]);
        }
        int total = sum[0];
        for(int i =1; i < index; i++){
            total -=sum[i];
        }
        System.out.println(total);
    }
}
