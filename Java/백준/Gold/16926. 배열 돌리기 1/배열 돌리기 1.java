import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, arr[][];
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        arr = new int[N][M];
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j < M; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        rotate();
        print();
        
        
    }
    
    public static void rotate(){
            for(int r = 0 ; r < R; r++){
                for(int i = 0 ; i < Math.min(N,M)/2; i++){
                    int temp = arr[i][i];
                    
                    for(int j = i; j < M-i-1; j++){
                        arr[i][j] = arr[i][j+1];
                    }
                    
                    for(int j = i; j < N-i-1; j++){
                        arr[j][M-1-i] = arr[j+1][M-1-i];
                    }
                    
                    for(int j = M-i-1; j > i; j--){
                        arr[N-1-i][j] = arr[N-1-i][j-1];
                    }                    
                    
                    for(int j = N-i-1; j > i ; j--){
                        arr[j][i] = arr[j-1][i];
                    }                    
                    arr[i+1][i] = temp;
                }                
            }
    }
    public static void print(){
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){            
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
