import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split("");
            for(int j = 0; j < M; j++){            
                char v = input[j].charAt(0);
                if(v == 'X') map[i][j] = -1;
            }
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){            
                if(map[i][j] == 0){
                    int cnt = 0;
                    for(int k = 0; k < 4; k++){
                        int nx = i + dx[k];
                        int ny = j + dy[k];                        
                        
                        if(!isIn(nx,ny)) continue;
                        if(map[nx][ny] == 0) cnt++;
                    }
                    if(cnt < 2){
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        System.out.println(0);
    }
    
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
