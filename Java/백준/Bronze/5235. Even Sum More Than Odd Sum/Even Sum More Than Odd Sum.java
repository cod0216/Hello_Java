import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            int idx = 0;
            int M = Integer.parseInt(input[idx++]);

            int a = 0;
            int b = 0;
            
            while(M-- > 0){
                int v = Integer.parseInt(input[idx++]);
                if(v % 2 == 0){
                    a += v;
                }else b += v;
            }            
            if(a > b) System.out.println("EVEN");
            else if(a < b) System.out.println("ODD");
            else System.out.println("TIE");
        }

    }
}
