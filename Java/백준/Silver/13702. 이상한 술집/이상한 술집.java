import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {    
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        long[] water = new long[N];
        long end = Long.MIN_VALUE;
        for(int i = 0 ; i < N; i++){
            water[i] = Long.parseLong(buffer.readLine());    
            end = Math.max(water[i], end);
        }
        
        
        long start = 1;
        long mid = 0;
        long ans = Long.MAX_VALUE;
        while(start <= end){
            mid = (start + end)/2;
            long sum = 0;
            long tresh = 0;
            for(int i = 0; i < N; i++){
                sum += water[i] / mid;
                tresh += water[i] % mid;
            }
            // ans = Math.min(ans,tresh);
            if(sum < M){
                end = mid-1;
            }else {
                ans = mid;
                start = mid+1;
            }
        }
        System.out.println(ans);
    }
}
