package TIL;

import java.io.*;
import java.util.*;


public class S2112 {
    static int cnt;
    static int[][] arr;
    static int[] check;
    static int d;
    static int w;
    static int k;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());

        int t = 0;



        while(T>t) {

            String[] input = buffer.readLine().split(" ");
            d = Integer.parseInt(input[0]);
            w = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);

            arr = new int[d][w];

            for (int i = 0; i < d; i++) {
                input = buffer.readLine().split(" ");
                for (int j = 0; j < w; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            cnt = d;
            if (!checking()) {
                DFS(0,0);
            }else cnt = 0;

            t++;
            System.out.println("#" + t + " " + cnt);
        }
    }

    public static void DFS(int index, int count){
        if(checking()){
                cnt = Math.min(count,cnt);
                return;
            }

            if(count >= cnt) return;

            if(index == d) return;

            int[] dummy = new int[w];

            for(int i = 0 ; i<w; i++){
                dummy[i] = arr[index][i];
            }
            DFS(index+1, count);

            for(int i = 0; i < w; i ++){
                arr[index][i] = 0;
            }
            DFS(index+1, count+1);
            for(int i = 0 ; i < w; i ++){
                arr[index][i] = 1;
            }
            DFS(index+1, count+1);

            for(int i = 0 ; i<w; i++){
                arr[index][i] = dummy[i];
            }
    }

    public static boolean checking() {
        for(int i = 0 ; i < w; i++){
            boolean dum = false;
            for(int j = 0; j <=d-k; j++){
                boolean dumdum = true;
                for(int z = 1; z <k; z++){
                    if(arr[j][i] != arr[j+z][i]) {
                        dumdum = false;
                        break;
                    }
                }
                if(dumdum){
                    dum = true;
                    break;
                }
            }
            if(!dum){
                return false;
            }
        }
        return true;
    }
}
