import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        int[][] map = new int[N][N];
        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split("");
            for(int j = 0; j < N; j++){
                char c = input[j].charAt(0);
                if(c == '.'){
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }   
        int row = 0;
        for(int i = 0 ; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(map[i][j] == 0) cnt++;
                else{
                    if(cnt >= 2) row++; 
                    cnt = 0;
                }
            }
            if(cnt >= 2) row++; 
        }
           
        int col = 0;
        for(int i = 0 ; i < N; i++){
            int cnt = 0;
            for(int j = 0; j < N; j++){
                if(map[j][i] == 0) cnt++;
                else{
                    if(cnt >= 2) col++; 
                    cnt = 0;
                }
            }
            if(cnt >= 2) col++; 
        }  
        
        System.out.println(row + " " + col);
    }

}
