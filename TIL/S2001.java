package TIL;
import java.util.*;
import java.io.*;

public class S2001 {
    static int[][] map;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            ans = 0;
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            map = new int[n][n];

            for(int i = 0 ; i< n; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0 ; j< n; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            for(int i = 0 ; i <= n-m; i++  ){
                for(int j = 0 ; j <= n-m; j++  ){
                    catchFly(i,j);

                }
            }

            t++;
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void catchFly(int x, int y){
        int sum = 0;
        for(int i = x; i< x+m; i++){
            for(int j = y; j< y+m; j++){
                sum += map[i][j];
            }
        }

        ans = Math.max(sum,ans);
    }
}