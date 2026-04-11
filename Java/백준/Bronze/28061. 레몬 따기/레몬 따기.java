import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int max = 0;
        
        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int lemon = Integer.parseInt(input[i]);
            max = Math.max(lemon - (N-i), max);
        }
        System.out.println(max);
    }
}
