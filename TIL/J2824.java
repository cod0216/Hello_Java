package TIL;

import java.io.*;
import java.util.*;

public class J2824 {
    public static void main(String[] args)throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        int numA = Integer.parseInt(buffer.readLine());
//        char[] charA = new char[numA];
//
        String[] input = buffer.readLine().split(" ");
//
//        for(int i = 0; i< numA; i++) {
//            charA[i] = input[i].charAt(0);
//        }
//
//        int numB = Integer.parseInt(buffer.readLine());
//        char[] charB = new char[numB];
//
//        input = buffer.readLine().split(" ");
//
//        for(int i = 0; i< numB; i++) {
//            charB[i] = input[i].charAt(0);
//        }












        int num1 = Integer.parseInt(input[0]);
        int num2 = Integer.parseInt(input[1]);

        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);


        int result = GCD(max, min);

        System.out.println(result);

    }
    public static int GCD(int a, int b) {
        if (a%b == 0)
            return b;

        return GCD(b, a%b);
    }

}

