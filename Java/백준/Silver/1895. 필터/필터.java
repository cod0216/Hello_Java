import java.util.*;
import java.io.*;

public class Main {
    static int N, M, map[][];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        int T = Integer.parseInt(buffer.readLine());
        
        int end = N-2;
        int x = 0;
        int y = 0;
        int cnt = 0;
        
        while(x != end){
            int v = search(x, y);
            if(v >= T) cnt++;
            y++;
            if(y == M-2){
                y = 0;
                x++;
            }
        }
        System.out.println(cnt);
    }
    
    public static int search(int startX, int startY){
        int[][] temp = new int[3][3];
        int[] sort = new int[9];
        int idx = 0;
        
        for(int i = startX; i < startX+3; i++){
            for(int j = startY; j < startY+3; j++){            
                sort[idx++] = map[i][j];
            }
        }
        
        Arrays.sort(sort);
        return sort[4];
    }
}
