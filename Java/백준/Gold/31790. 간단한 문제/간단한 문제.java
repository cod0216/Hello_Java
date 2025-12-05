import java.util.*;
import java.io.*;

public class Main {
    static int N, M, A[], temp;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        A = new int[N];
        input = buffer.readLine().split(" ");
        for(int i = 0 ; i < N; i++){    
            A[i] =  Integer.parseInt(input[i]);   
        }
        
        System.out.println(process() ? "YES" : "NO");
    }
    
    public static boolean process(){
        if(A[0] != 1) return false;
        if(A[N-1] != (N + M -1)/M) return false;
        
        for(int i = 1; i < N; i++){
            if(A[i] < A[i-1]) return false;
            if(A[i] > A[i-1] + 1) return false;
        }
        
        for(int i = 0 ; i < N; i++){
            int temp = ( (i+1) + M -1) / M;
            if(A[i] < temp) return false;
        }
        return true;
    }
}
