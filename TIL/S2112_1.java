package TIL;

import java.io.*;
import java.util.*;

public class S2112_1 {
    static int[][] map;
    static int dose;
    public static void main(String args[]) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());

        int t = 0;

        while(T >t){
            String[] input  = buffer.readLine().split(" ");
            int D = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int K = Integer.parseInt(input[2]);
            dose = Integer.MAX_VALUE;

            map = new int[D][W];

            for(int i = 0; i < D; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0; j < W; j++){
                    map[i][j] = Integer.parseInt(input[j]);

                }
            }
            if(inspect(D,W,K,map)) dose = 0;
            else dfs(0, D, W, K, map, 0);

            t++;
            System.out.println("#" + t + " " + dose);
        }

    }

    public static void dfs(int target, int D, int W, int K, int[][] map, int num){
        if(num > dose) return;
        if(inspect(D,W,K,map)){
            dose = Math.min(num,dose);
            return;
        }
        if(target >= D) return;

        int[] backup = Arrays.copyOf(map[target], W);

        dfs(target+1,D,W,K,map,num);

        Arrays.fill(map[target], 0);
        dfs(target+1,D,W,K,map,num+1);

        Arrays.fill(map[target], 1);
        dfs(target+1,D,W,K,map, num+1);

        System.arraycopy(backup, 0, map[target], 0, W);

    }

    public static boolean inspect(int D, int M, int K, int[][] doseMap){
        for(int i = 0; i < M; i++){
            boolean next =  (K == 1);
            int cnt = 1;
            for(int j = 0; j < D-1; j++){
                if(doseMap[j][i] == doseMap[j+1][i]) cnt++;
                else cnt = 1;
                if(cnt >= K){
                    next = true;
                    break;
                }
            }
            if(!next) return false;
        }
        return true;
    }
}

