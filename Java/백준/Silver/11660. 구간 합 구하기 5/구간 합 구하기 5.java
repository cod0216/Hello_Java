import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map, temp;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N+1][N+1];
        temp = new int[N+1][N+1];
        
        int sum = 0;
        
        for(int i = 1; i <= N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
                
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                temp[i][j] = map[i][j] + temp[i-1][j] + temp[i][j-1] - temp[i-1][j-1];
            }
        }
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            int d = Integer.parseInt(input[3]);
            
            int ans = temp[c][d] - temp[a-1][d] 
                - temp[c][b-1] + temp[a-1][b-1];      
            System.out.println(ans);
            
        }
        
        
    }
}
