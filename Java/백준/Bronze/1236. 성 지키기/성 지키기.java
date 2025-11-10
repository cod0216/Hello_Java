import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int  l = N;
        int  r = M;
        char x = 'X';
        char[][] map = new char[N][M];
        
        for(int i = 0 ; i < N; i++){
            String[] line = buffer.readLine().split("");
            for(int j = 0 ; j < M; j++){
                map[i][j]= line[j].charAt(0);
            }
        }
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                if(map[i][j] == x){
                    l--;
                    break;
                }
            }
        }
        
        for(int i = 0 ; i < M; i++){
            for(int j = 0 ; j < N; j++){
                if(map[j][i] == x){
                    r--;
                    break;
                }
            }
        }
        
        System.out.println(Math.max(r,l));
    }
}
