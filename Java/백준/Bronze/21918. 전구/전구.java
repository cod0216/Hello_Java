import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);        
        arr = new int[N+1];
        
        input = buffer.readLine().split(" ");
        for(int i = 1 ; i <= N; i++){
            arr[i] = Integer.parseInt(input[i-1]);
        }

        for(int i = 0 ; i < M; i++){        
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            select(a,b,c);
        }
        
        for(int i = 1 ; i <= N; i++){
            System.out.print(arr[i]+ " ");
        }
    }
    
    public static void select(int a, int b, int c){
        switch(a){
            case 1 :
                arr[b] = c;
                break;
            case 2 :
                for(int i = b; i<=c; i++){
                    if(arr[i]  == 1) arr[i] = 0;
                    else arr[i] = 1;
                }
                break;
            case 3 :
                for(int i = b; i <= c; i++){
                    arr[i] = 0;
                }
                break;
            case 4 :
                for(int i = b; i <= c; i++){
                    arr[i] = 1;
                }
                break;
                
        }
    }
}
