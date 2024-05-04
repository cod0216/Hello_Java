package TIL;

import java.io.*;
import java.util.*;

public class J1016 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long num1 = Long.parseLong(input[0]);
        long num2 = Long.parseLong(input[1]);

        long cnt = 0;

        for(long i = num1; i<=num2; i++){
            if((Math.sqrt(i)*Math.sqrt(i)) != i)
                cnt++;
        }
        System.out.println(cnt);
    }
}
