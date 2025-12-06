import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");
        int N = input.length;
        char[] A = new char[N];
        
        for(int i = 0 ; i < N; i++){
            A[i] = input[i].charAt(0);
        }

        int sum = 0;
        
        input = buffer.readLine().split("");
        int M = input.length;
        char[] B = new char[M];
        for(int i = 0 ; i < M; i++){
            B[i] = input[i].charAt(0);
        }
        
        int start = 0;
        int end = M;
        int cnt = 0;
        
        while(end <= N){
            int idx = 0;
            boolean isNot = false;
            for(int i = start; i< end; i++){
                if(A[i] != B[idx++]){
                    isNot = true;
                    break;  
                } 
            }
            
            if(isNot){
                start++;
                end++;
            }else{
                start = end;
                end = end+M;
                cnt++;
            }
        }

        System.out.println(cnt);
        
    }
}
