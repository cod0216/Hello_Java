package TIL;

import java.io.*;
import java.util.*;

public class S5215 {
    static int n;
    static int result;
    static int[] yamy;
    static int cal;
    static int[] c;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t) {
            String[] input = buffer.readLine().split(" ");
            result = 0 ;
            n = Integer.parseInt(input[0]);
            cal = Integer.parseInt(input[1]);
            visited = new boolean[n];

            yamy = new int[n];
            c = new int[n];



            for(int i = 0; i < n; i++){
                input = buffer.readLine().split(" ");
                yamy[i] = Integer.parseInt(input[0]);
                c[i] = Integer.parseInt(input[1]);
            }

            combination(0,0,0);
            t++;
            System.out.println("#"+t+" "+ result);

        }
    }

    static public void combination(int index, int calo, int score){
        if(calo > cal){
            return;
        }
        if(index == n){
            result = Math.max(result, score);
            return;
        }

        int dummy = c[index];
        int point = yamy[index];
        combination(index+1, calo+dummy, point+score);
        combination(index+1, calo, score);
    }
}

