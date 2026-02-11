import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        int[] arr = new int[M+1];
        
        Arrays.fill(arr, 1);
        arr[1] = 0;
        
        for(int i = 2; i <= M; i++){
            if(arr[i] == 0) continue;
            int cnt = 2;
            for(int j = i; j <= M; j = i*cnt){
                if(j == i) continue;
                arr[j] = 0;
                cnt++;
            }
        }
        
        for(int i = N ; i <= M; i++){
            if(arr[i] == 1)
            System.out.println(i);
        }
    }
}
