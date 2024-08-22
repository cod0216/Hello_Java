package TIL;

import java.util.*;
import java.io.*;


public class S1486 {
    static int min;
    static int N;
    static int[] arr;
    static int totalHigh;

    public static void main(String[] args)throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t=0;
        while(T>t) {
            String[] input = buffer.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            totalHigh = Integer.parseInt(input[1]);

            arr = new int[N];
            min = Integer.MAX_VALUE;

            input = buffer.readLine().split(" ");

            for(int i = 0 ; i < N;i++){
                arr[i]=Integer.parseInt(input[i]);
            }



            powerSet(0,0);
            t++;
            System.out.println("#"+t+" " + min);
        }

    }

    public static void powerSet(int depth, int nowMin) {
        if(depth == N) {

            if(nowMin >= totalHigh) {
                nowMin = nowMin - totalHigh;
                min = Math.min(min, nowMin);
            }
            return;
        }

        if(nowMin >= totalHigh) {
            nowMin = nowMin - totalHigh;
            min = Math.min(min, nowMin);
            return;
        }

        powerSet(depth+1, nowMin+arr[depth]);
        powerSet(depth+1, nowMin);
    }
}