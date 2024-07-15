package TIL;

import java.io.*;
import java.util.*;

public class s2032 {
    public static void main(String[] args) throws IOException{
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};



        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(buffer.readLine());

        int[][] ground = new int[N][N];

        for(int i = 0; i<N; i++){
            String[] str = buffer.readLine().split(" ");
            for(int j = 0; j < N; j++){
                ground[i][j] = Integer.parseInt(str[j]);
            }
        }
        int nx;
        int ny;
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int sum = ground[i][j];
                for(int k = 0; k <4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if(nx >=0 && nx <N && ny >=0 && ny <N){
                        sum += ground[nx][ny];
                    }
                }
                if(max < sum){
                    max = sum;
                }

            }
        }
        System.out.println(max);
    }
}
