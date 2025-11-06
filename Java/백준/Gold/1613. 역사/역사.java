import java.util.*;
import java.io.*;

public class Main {
    static int N, M, dist[][];
    static LinkedList<int[]>[] list;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        list = new LinkedList[N+1];
        dist = new int[N+1][N+1];
        
        for(int i = 0 ; i <M; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            dist[s][e] = 1;
        }
        
        for(int z = 1; z <=N; z++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <=N; j++){
                    if(dist[i][z]==1 && dist[z][j] ==1)
                        dist[i][j] = 1;
                }
            }
        }
        
        int k = Integer.parseInt(buffer.readLine());
        
        for(int i = 0; i < k; i++) {
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            if(!isIn(s,e)) System.out.println(0);
            else {
                if(dist[s][e] == 1 ) System.out.println(-1);                
                else if(dist[e][s] == 1) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
    public static boolean isIn(int x, int y){
        return x > 0 && y > 0 && x <= N && y<= N;
    }
}
