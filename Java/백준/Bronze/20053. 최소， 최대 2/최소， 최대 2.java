import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        
        while(T --> 0) {
            int N = Integer.parseInt(buffer.readLine());
            String[] input = buffer.readLine().split(" ");
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            
            for(int i = 0 ; i < N; i++){
                max = Math.max(max,Integer.parseInt(input[i]));
                min = Math.min(min,Integer.parseInt(input[i]));
            }
            
            System.out.println(min + " " + max);
        }
    }
}
