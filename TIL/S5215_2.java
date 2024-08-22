package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S5215_2 {
    static int max;
    static int[] score;
    static int[] calo;
    static int maxCalo;
    static boolean[] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T >t){
            max = Integer.MIN_VALUE;

            String[] input  = buffer.readLine().split(" ");
            maxCalo = Integer.parseInt(input[1]);
            n = Integer.parseInt(input[0]);
            visited = new boolean[n];

            score = new int[n];
            calo = new int[n];

            for(int i = 0 ; i < n; i++){
                input  = buffer.readLine().split(" ");
                score[i] = Integer.parseInt(input[0]);
                calo[i] = Integer.parseInt(input[1]);
            }

            combination(0,0,0);
//            powerSet(0,0,0);
            t++;
            System.out.println("#" + t+ " " + max);
        }
    }
    public static void combination(int index, int cal, int num){
        if(cal >maxCalo ){
            return;
        }
        if(cal <= maxCalo ){
            max = Math.max(max, num);
        }
        if(index >= n){
            return;
        }
        for(int i = index; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                combination( i+1, cal+calo[i], num+score[i]);
                visited[i] = false;
            }
        }



    }

    public static void powerSet(int start, int cal, int num){
        if(cal >maxCalo ){
            return;
        }
        if(cal <= maxCalo ){
            max = Math.max(max, num);
        }
        if(start >= n){
            return;
        }
        for(int i = start ; i < n; i++){
            powerSet(i+1, cal+calo[i], num+score[i]);
            powerSet(i+1, cal, num);
        }
    }
}
