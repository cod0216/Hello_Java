package TIL;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class J2407 {
    public static void main(String[] args)throws IOException  {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int n1 = Integer.parseInt(input[0]);
        int n2 = Integer.parseInt(input[1]);

        BigInteger[][] array = new BigInteger[n1+1][n1+1];

        for(int i = 0 ; i <= n1; i++) {
            array[i][1] = BigInteger.valueOf(i);
            array[i][0] = BigInteger.valueOf(1);
            array[i][i] = BigInteger.valueOf(1);
        }
        for(int i = 2; i<=n1; i++){
            for(int j = 1 ; j <i; j++){
                array[i][j]= array[i-1][j].add(array[i-1][j-1]);
            }
        }
        System.out.println(array[n1][n2].toString());
    }
}
