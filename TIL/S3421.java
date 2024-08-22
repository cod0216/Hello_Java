package TIL;

import java.io.*;
import java.util.*;

public class S3421 {
    static int n;
    static int m;
    static int[] bugger;
    static boolean[][] no;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        StringBuilder sb = new StringBuilder();

        while (T > t) {
            String[] input = buffer.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            no = new boolean[400][400];


            for (int i = 0; i < m; i++) {
                input = buffer.readLine().split(" ");
                int num1 = Integer.parseInt(input[0]);
                int num2 = Integer.parseInt(input[1]);
                no[num1][num2] = no[num2][num1] = true;
            }

            cnt = 0;
            bugger = new int[n];
            boolean[] visited = new boolean[n];
            comb(0,0,visited);
            t++;
            sb.append("#" + t + " " + cnt + "\n");
        }
        System.out.println(sb);
    }

    public static void comb(int start, int index, boolean[] visited){
        cnt++;
        for(int i = start; i < n; i++){
            if(!visited[i] && !check(i+1,index)){
                visited[i] = true;
                bugger[index] = i+1;
                comb(i+1, index+1, visited);
                visited[i]=false;
                bugger[index] = 0;
            }
        }
    }

    public static boolean check(int value , int index){
        for(int i = 0; i < index; i++){
            if(no[value][bugger[i]]){
                return true;
            }
        }
        return false;
    }
}

