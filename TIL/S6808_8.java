package TIL;

import java.io.*;
import java.util.*;

public class S6808_8 {
    static int ans, winA, winB;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
            ans = 0;
            winA = 0;
            winB = 0;
            String input[] = buffer.readLine().split(" ");

            int[] A = new int[9];
            int[] B = new int[9];

            for (int i = 0; i < 9; i++) {
                A[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(A);

            int idxA = 0;
            int idxB = 0;

            for (int i = 1; i <= 18; i++) {
                if(idxA != 9 && A[idxA] == i){
                    idxA++;
                    continue;
                }
                B[idxB] = i;
                idxB++;
            }


            dfs(A, A[0], B, B[0], 0,0,0, new boolean[9]);


            t++;
            System.out.println("#" + t + " " + winA + " " + winB);
        }
    }

    public static void dfs(int[] A, int valueA, int[] B, int valueB, int scoreA, int scoreB, int idx, boolean[] visitiedB){
        if(idx == 9){
            if(scoreA > scoreB){
                winA++;
            } else if (scoreA < scoreB) {
                winB++;
            }
            return;
        }

        for (int i = 0; i <9 ; i++) {
            if(visitiedB[i])continue;
            visitiedB[i] = true;
            if(A[idx] > B[i] ) {
                dfs(A, A[idx], B, B[i], scoreA+A[idx]+B[i], scoreB, idx+1,visitiedB );
            }else if(A[idx] < B[i] ) {
                dfs(A, A[idx], B, B[i], scoreA, scoreB+B[i]+A[idx], idx+1,visitiedB );
            }
            visitiedB[i] = false;
        }
    }
}
