package TIL.review;

import java.util.*;
import java.io.*;

public class J1934 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());

            for(int i =0; i< n; i++) {
                String[] input = buffer.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                int max = Math.max(a, b);
                int min = Math.min(a, b);

                while (max % min != 0) {
                    int temp = max;
                    max = min;
                    min = temp % min;
                }
                System.out.println((a*b)/min);
            }
    }
}
