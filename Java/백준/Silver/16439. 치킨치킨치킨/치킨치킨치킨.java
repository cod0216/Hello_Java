import java.io.*;
import java.util.*;

public class Main {
    static int N, M, map[][], result;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
 
        String[] input = buffer.readLine().split(" ");
 
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
 
        map = new int[N][M];
        visited = new boolean[M];
        for(int i= 0; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
 
        dfs(0,0);
 
        System.out.println(result);
    }
    public static void dfs(int s, int d){
        if(d == 3){
            int score = 0;
            for(int i = 0 ; i < N; i++){
                int temp = 0;
                for(int j = 0; j < M; j++){
                    if(visited[j]){
                       temp = Math.max(map[i][j],temp);                        
                    }
                }
                score += temp;

            }
            result = Math.max(result, score);                        
            return;
        }
        
        for(int i = s; i < M; i++){
            if(!visited[i]){
                visited[i] = true;                
                dfs(i+1, d+1);
                visited[i] = false;
            }
        }
    }
}