import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R;
    static int[][] map;
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        map = new int[N][M];
        
        for(int i = 0 ; i < N; i++){
           input = buffer.readLine().split(" ");
            for(int j = 0 ; j < M; j++){            
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        
        int min = Math.min(N,M)/2;
        
        for(int i = 0; i < min; i++){
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j = i; j < M-i; j++) list.add(map[i][j]);
            for(int j = i+1; j < N-i; j++) list.add(map[j][M-1-i]);
            for(int j = M-2-i; j >= i; j--) list.add(map[N-i-1][j]);
            for(int j = N-2-i; j > i; j--) list.add(map[j][i]);
            
            int size = list.size();
            // if(size == 0 ) continue;
            // System.out.println(size);
            int rotate = R % size;
            
            Collections.rotate(list, -rotate);
            int idx = 0;
            for(int j = i; j < M-i; j++) map[i][j] = list.get(idx++);
            for(int j = i+1; j < N-i; j++) map[j][M-1-i] = list.get(idx++);
            for(int j = M-2-i; j >= i; j--) map[N-i-1][j] = list.get(idx++);
            for(int j = N-2-i; j > i; j--) map[j][i] = list.get(idx++);
        }
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){            
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
    }
}
