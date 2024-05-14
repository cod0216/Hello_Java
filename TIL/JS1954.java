package TIL;

import java.util.*;
import java.io.*;

public class JS1954 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int[] dx= new int[]{1, 0, -1, 0};
        int[] dy= new int[]{0, 1, 0, -1};

        int c = 0;
        while(c != T) {
            int num = 1;
            int N = Integer.parseInt(buffer.readLine());
            int[][] array = new int[N][N];
            array[0][0]= num++;
            int x = 0;
            int y = 0;
            int d =0;
            while(num != (N*N)+1){
                x += dx[d%4];
                y += dy[d%4];
                if(x>=0 && y>=0 && x <N && y < N) {
                    if(array[y][x] ==0)
                        array[y][x] = num++;
                    else {
                        x -= dx[d%4];
                        y -= dy[d%4];
                        d += 1;
                    }
                } else {
                    x -= dx[d%4];
                    y -= dy[d%4];
                    d += 1;
                }
            }
            System.out.println("#" + c+1);
            for(int i =0; i< N; i++){
                for(int j =0; j<N; j++){
                    System.out.print(array[i][j] + " ");
                }
                System.out.println();
            }
            c++;
        }
    }
}
