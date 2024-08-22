package TIL;

import java.io.*;
import java.util.*;

public class J2961 {
    static int[] bit;
    static int[] sour;
    static int n;
    static int min;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());
        min = Integer.MAX_VALUE;
        bit = new int[n];
        sour = new int[n];
        for(int i = 0 ; i < n; i ++){
             String[] input = buffer.readLine().split(" ");
             bit[i] = Integer.parseInt(input[0]);
             sour[i] = Integer.parseInt(input[1]);
        }

//        powerSet(0,1,0);
        comb(0,1,0);

        System.out.println(min);
    }
    public static void powerSet(int start, int nBit, int nSour){
        if(start == n){
            int value = Math.abs(nBit-nSour);
            min = Math.min(min, value);
            return;
        }

        for(int i = start; i <n; i++){
            powerSet(i+1, nBit*bit[i], nSour+sour[i]);
        }
    }
    public static void comb(int start, int nBit, int nSour){
        if(start == n){
            if(nSour != 0 ){
                int value = Math.abs(nBit-nSour);
                min = Math.min(min, value);
            }
            return;
        }

        comb(start+1, nBit*bit[start], nSour+sour[start]);
        comb(start+1, nBit, nSour);
    }
}
