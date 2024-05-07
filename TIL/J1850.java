package TIL;

import java.util.*;
import java.io.*;

public class J1850 {
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long a= Long.parseLong(input[0]);
        long b= Long.parseLong(input[1]);


        long min = Math.min(a, b);
        long max = Math.max(a, b);

        while(max%min > 0){
            long temp = min;
            min = max % min;
            max = temp;
        }

        long C = 1;

        for(int i = 1; i <min; i++){
            C = C*10+1;
        }
        System.out.println(C);
    }
}
