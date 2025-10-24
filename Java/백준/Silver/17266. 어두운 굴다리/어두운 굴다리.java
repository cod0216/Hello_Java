import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int M = Integer.parseInt(buffer.readLine());
        
        int[] pos = new int[M];
        
        String[] input = buffer.readLine().split(" ");
        
        for(int i = 0 ; i < M; i++){
            pos[i] = Integer.parseInt(input[i]);
        }
        
        int first = pos[0];
        int diff = pos[0];
        for(int i = 1 ; i < M; i++){
          int cur = pos[i] - pos[i-1];  
          diff = Math.max(diff, cur);
        }
        
        int last = N-pos[M-1];
        diff = Math.max(diff, last);
        
        
        int ans = 0;
        
        if(diff % 2 == 1){
          ans = diff/2 + 1;
        }else ans = diff/2;
        
        if(ans < last || ans < first) ans = Math.max(last,first);

        System.out.println(ans);
    }
    
}
