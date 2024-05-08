package TIL.review;

import java.util.*;
import java.io.*;

public class J1850 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String input[] = buffer.readLine().split(" ");

        long a = Long.parseLong(input[0]);
        long b = Long.parseLong(input[1]);

        long min = Math.min(a, b);
        long max = Math.max(a, b);

        while(max%min != 0){
            long temp = max;
            max = min;
            min = temp%min;
        }

        long key = min;

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < key; i ++){
            builder.append("1");
        }
        String str = builder.toString();

        System.out.println(str);
    }
}
