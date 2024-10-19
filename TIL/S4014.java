package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S4014 {
    static int n, l, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
            String[] input = buffer.readLine().split(" ");
            n = Integer.parseInt(input[0]);
            l = Integer.parseInt(input[1]);

            map = new int[n][n];

            for(int i = 0 ; i < n; i ++){
                input = buffer.readLine().split(" ");
                for(int j = 0 ; j < n; j ++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            } // map input end

            int ans = 0;
            for(int i = 0; i < n; i++){
                if(col(i)) ans++;
                if(row(i)) ans++;
            }
            t++;
            System.out.println("#" + t + " " + ans);

        } // T case while end

    }
    public static boolean col(int num){
        boolean[] incline = new boolean[n];
        for(int i = 0; i < n-1; i++){
            int high = map[i][num] - map[i+1][num];
            if(Math.abs(high)>1) return false;
            if(high == 1){
                for(int j = 1; j<= l; j++){
                    if(i+j >=n || incline[i+j]) return false;
                    if(map[i][num] - map[i+j][num]!= 1) return false;
                    incline[i+j] = true;
                }
            }
            if(high == -1){
                for(int j = 0; j< l; j++){
                    if(i-j <0 || incline[i-j]) return false;
                    if(map[i][num] - map[i-j][num]!= 0) return false;
                    incline[i-j] = true;
                }
            }
        }
        return true;
    }

    public static boolean row(int num){
        boolean[] incline = new boolean[n];
        for(int i = 0; i < n-1; i++){
            int high = map[num][i] - map[num][i+1];
            if(Math.abs(high)>1) return false;
            if(high == 1){
                for(int j = 1; j<= l; j++){
                    if(i+j >=n || incline[i+j]) return false;
                    if(map[num][i] - map[num][i+j]!= 1) return false;
                    incline[i+j] = true;
                }
            }
            if(high == -1){
                for(int j = 0; j< l; j++){
                    if(i-j <0 || incline[i-j]) return false;
                    if(map[num][i] - map[num][i-j]!= 0) return false;
                    incline[i-j] = true;
                }
            }
        }
        return true;
    }
}
