import java.io.*;
import java.util.*;


public class J14890_1 {
    static int N, L, map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);

        map = new int[N][N];
        for(int i = 0; i< N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j< N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        } //input end;

        int ans = 0;
        for(int i = 0 ; i < N; i++){
            if(col(i)) ans++;
            if(row(i)) ans++;
        }

        System.out.println(ans);
    }

    public static boolean col(int num) {
        boolean[] incline = new boolean[N];
        for(int i = 0 ; i < N-1; i++){
            if(Math.abs(map[i][num]- map[i+1][num]) > 1)
                return false;
            if(map[i][num] - map[i+1][num] == 1){
                for(int j = 1 ; j <= L; j++){
                  if(i+j>=N || incline[i+j]) return false;
                  if((map[i][num] -1) != map[i+j][num] ) return false;
                  incline[i+j] = true;
                }
            }
            else if (map[i][num] - map[i+1][num] == -1){
                for(int j = 0; j< L; j++){
                    if(i-j < 0 || incline[i-j]) return false;
                    if(map[i][num] != map[i-j][num]) return false;
                    incline[i-j]= true;
                }
            }
        }
        return true;
    }
    public static boolean row(int num) {
        boolean[] incline = new boolean[N];
        for(int i = 0 ; i < N-1; i++){
            if(Math.abs(map[num][i] - map[num][i+1]) > 1) return false;
            if(map[num][i] - map[num][i+1] == 1){
                for(int j = 1; j<=L; j++){
                    if(i+j >= N || incline[i+j]) return false;
                    if(map[num][i]-map[num][i+j] != 1) return false;
                    incline[i+j] = true;
                }
            }
            else if (map[num][i] - map[num][i+1] == -1){
                for(int j = 0; j< L; j++){
                    if(i-j<0 || incline[i-j]) return false;
                    if(map[num][i]-map[num][i-j] != 0 ) return false;
                    incline[i-j] = true;
                }
            }
        }
        return true;
    }
}
