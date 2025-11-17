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
        
        int l = Math.min(M, N)/2;
        
        for(int i = 0 ; i <l ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int j = i ; j < M-i; j++) list.add(arr[i][j]);
            for(int j = i+1 ; j < N-i; j++) list.add(arr[j][M-1-i]);
            for(int j = M-2-i ; j >= i; j--) list.add(arr[N-1-i][j]);
            for(int j = N-2-i ; j > i; j--) list.add(arr[j][i]);   

            int len = list.size();
            int rotate = R % len;
            
            Collections.rotate(list, -rotate);
            int index = 0;
            
                
            for(int j = i ; j < M-i; j++) arr[i][j]= list.get(index++);
            for(int j = i+1 ; j < N-i; j++) arr[j][M-1-i] = list.get(index++);                    
            for(int j = M-2-i ; j >= i; j--) arr[N-1-i][j] = list.get(index++);
            for(int j = N-2-i ; j > i; j--) arr[j][i] = list.get(index++);

         
            
        }
        

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
        
        
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
