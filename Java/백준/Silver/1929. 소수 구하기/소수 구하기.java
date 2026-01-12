import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        boolean[] prime = new boolean[M+1];
        
        for(int i = 2; i <= M; i++){
            if(!prime[i]){
                if(i>=N) System.out.println(i);
                int idx = i;
                int n = 2;
                while(idx <= M){
                    prime[idx] = true;
                    idx = i*n++;
                }
            }
        }
    }
}
