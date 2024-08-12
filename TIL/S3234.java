package TIL;

import java.util.*;
import java.io.*;


public class S3234 {
    static int cnt;
    static int n;
    static int[] chu;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(buffer.readLine());
        int k = 0;



        while(K>k){
            n = Integer.parseInt(buffer.readLine());
            visited = new boolean[n];

            String[] input = buffer.readLine().split(" ");

            chu = new int[n];

            for(int i = 0; i < n; i ++){
                chu[i] = Integer.parseInt(input[i]);
            }
            cnt = 0;


            DFS(0,0,0);

            k++;
            System.out.println("#" + k + " " +cnt);
        }


    }
    static public void DFS(int idxCnt, int right, int left){

        if(idxCnt >= n){
            if(right <= left){
                cnt++;
            }
            return;
        }
        for(int i = 0; i< n; i++) {
            if (idxCnt < n) {
                if (!visited[i]) {
                    visited[i] = true;
                    DFS(idxCnt + 1,  right, left + chu[i]);
                    if (right + chu[i] <= left) {
                        DFS(idxCnt + 1, right + chu[i], left);
                    }

                    visited[i] = false;
                }
            }
        }
    }
}
