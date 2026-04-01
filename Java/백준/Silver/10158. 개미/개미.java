import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        input = buffer.readLine().split(" ");
        int X = Integer.parseInt(input[0]);
        int Y = Integer.parseInt(input[1]);
        
        int T = Integer.parseInt(buffer.readLine());
        
        
        int a = (X + T) % (N*2);
        int b = (Y + T) % (M*2);
        
        if (a > N) a = 2*N - a;
        if (b > M) b = 2*M - b;
        
        System.out.println(a + " " + b);
        

    }
}
