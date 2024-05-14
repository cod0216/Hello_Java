package TIL;

import java.util.*;
import java.io.*;

public class JS2072 {
    public static void main(String[] args) throws IOException{
       BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(buffer.readLine());
       int M = 0;
        while(M != N) {
            String[] input = buffer.readLine().split(" ");
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                if((Integer.parseInt(input[i]))%2!= 0){
                    sum += Integer.parseInt(input[i]);
                }
            }
            System.out.println(sum);
            M++;
        }
    }
}
