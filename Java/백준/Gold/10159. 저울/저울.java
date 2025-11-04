import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int M = Integer.parseInt(buffer.readLine());
        
        boolean[][] arr = new boolean[N+1][N+1];
        
        for(int i = 0 ; i < M; i++){
            String[] input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            arr[a][b] = true;
        }
        
        for(int k = 1 ; k <= N; k++){
            for(int i = 1 ; i <= N; i++){
                for(int j = 1 ; j <= N; j++){
                    if(arr[i][k] && arr[k][j]){
                        arr[i][j] = true;
                    }
                }
            }
        }
        
        for(int i = 1 ; i <= N; i++){
            int cnt = 0;
            for(int j = 1 ; j <= N; j++){
                if(i != j && (arr[i][j] || arr[j][i]))cnt++;
            }
            System.out.println(N-1-cnt);
        }
    }
}
