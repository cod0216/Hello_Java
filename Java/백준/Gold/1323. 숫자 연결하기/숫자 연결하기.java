import java.util.*;
import java.util.function.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        Predicate<Long> predicate = n -> n%2 == 0;
        
        long N = Long.parseLong(input[0]);
        int M = Integer.parseInt(input[1]);

        int len = String.valueOf(N).length();
        int temp = 1;
        
        for (int i = 0; i < len; i++) {
            temp = (temp * 10) % M;
        }

        int cur = 0;
        for (int i = 1; i <= M; i++) {
            cur = (int)((cur * 1L * temp + (N % M)) % M);
            if (cur == 0) {
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
