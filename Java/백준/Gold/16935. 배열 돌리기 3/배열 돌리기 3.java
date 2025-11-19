import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, map[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]); 
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        
        map = new int[N][M];
        
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]); 
            }
        }
        input = buffer.readLine().split(" ");
        int idx = 0;
        while(R --> 0){
            int n = Integer.parseInt(input[idx++]);
            if(n == 1){
                one();
            } else if (n == 2){
                two();
            } else if(n == 3){
                three();
            } else if(n == 4){
                four();
            } else if(n == 5) {
                five();
            } else if(n == 6) {
                six();
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
    public static void one(){
        for(int i = 0 ; i < N/2; i++){
            for(int j = 0 ; j < M; j++){
                int temp = map[i][j];
                map[i][j] = map[N-i-1][j];
                map[N-i-1][j] = temp;
            }
        }
    }
    
    public static void two(){
        for(int i = 0 ; i < M/2; i++){
            for(int j = 0; j < N; j++){
                int temp = map[j][i];
                map[j][i] = map[j][M-i-1];
                map[j][M-i-1] = temp;
            }
        }
    }    
    
    public static void three(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                list.add(map[i][j]);
            }
        }
        
        int t = N;
        N = M;
        M = t;
        map = new int[N][M];
        int idx = list.size()-1;
        
        for(int i = 0; i < M; i++){
            for(int j = N-1 ; j >= 0; j--){
                map[j][i] = list.get(idx--);
            }
        }

    }    
    
    public static void four(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            for(int j = 0; j < M; j++){
                list.add(map[i][j]);
            }
        }
        int t = N;
        N = M;
        M = t;
        map = new int[N][M];
        int idx = 0;
        
        for(int i = 0; i < M; i++){
            for(int j = N-1 ; j >= 0; j--){
                map[j][i] = list.get(idx++);
            }
        }
        

    }    
    public static void five(){
        int h = N/2;
        int w = M/2;
        
        int[][] temp = new int[N][M];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                temp[i][j] = map[i][j];
            }
        }
        
        for(int i = 0; i < h; i++){
            for(int j = w; j < M; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[i][j-w];
            }
        }
        
        for(int i = h; i< N; i++){
            for(int j = w; j<M; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[i-h][j];
            }
        }
        
        for(int i = h; i< N; i++){
            for(int j = 0; j < w; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[i][w+j];
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                map[i][j] = temp[i+h][j];
            }
        }
        
    }
    public static void six(){
        int h = N/2;
        int w = M/2;
        
        int[][] temp = new int[N][M];
        
        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                temp[i][j] = map[i][j];
            }
        }
        
        for(int i = h; i < N; i++){
            for(int j = 0; j < w; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[i-h][j];
            }
        }
        
        for(int i = h; i< N; i++){
            for(int j = w; j<M; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[i][j-w];
            }
        }
        
        for(int i = 0; i< h; i++){
            for(int j = w; j < M; j++){
                temp[i][j] = map[i][j];
                map[i][j] = temp[h+i][j];
            }
        }

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                map[i][j] = temp[i][j+w];
            }
        }
        
    }
}
