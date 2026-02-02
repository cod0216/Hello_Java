import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] map = {
        {true, true, true, true, true, true, false},
        {false, true, true, false, false, false, false},
        {true, true, false, true, true, false, true},
        {true, true, true, true, false, false, true},
        {false, true, true, false, false, true, true},
        {true, false, true, true, false, true, true},
        {true, false, true, true, true, true, true},
        {true, true, true, false, false, false, false},
        {true, true, true, true, true, true, true},
        {true, true, true, true, false, true, true}
    };
    
    
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);        
        int K = Integer.parseInt(input[1]);        
        int P = Integer.parseInt(input[2]);
        int X = Integer.parseInt(input[3]);
        
        String xStr = String.format("%0" + K + "d", X);
        int res = 0;
        for(int i = 1; i <=N; i++){
            if(i == X) continue;
            
            String now = String.format("%0" + K + "d", i);
            int diff = 0;
            
            for(int j = 0; j < K; j++){
                int a = xStr.charAt(j) - '0';
                int b = now.charAt(j) - '0';
                diff += matchNum(a,b);
            }
            
            if(diff <= P) res++;
            
        }
        

        System.out.println(res);

    }
    
    public static int matchNum(int src, int target){
        int cnt = 0;
        for(int i = 0 ; i < 7; i++){
            if(map[src][i] != map[target][i]) cnt++;
        }
        return cnt;
    }
}
