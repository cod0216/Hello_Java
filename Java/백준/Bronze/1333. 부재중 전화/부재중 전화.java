import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);

        int ring = D;
        
        for(int i = 0; i < N; i++){
            int end = (L + 5) * i + L;
            int restEnd = end + 5;
            
            while(ring < end) ring += D;
            
            if(ring < restEnd){
                System.out.println(ring);  
                return;
            } 
        }
        int total = N*L + (N-1)*5;
        while(ring < total) ring += D;
        System.out.println(ring);
        
    }
}
