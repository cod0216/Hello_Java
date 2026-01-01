import java.util.*;
import java.io.*;

public class Main {
    static long N, P, Q ,X, Y;
    static HashMap<Long, Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Long.parseLong(input[0]);
        P = Long.parseLong(input[1]);
        Q = Long.parseLong(input[2]);
        X = Long.parseLong(input[3]);
        Y = Long.parseLong(input[4]);
        
        System.out.println(get(N));
    }
    public static long get(long n){
        if(map.get(n) == null) put(n);
        return map.get(n);
    }
    public static void put(long n){
        if(n <= 0)map.put(n, 1L);
        else map.put(n, get(n / P-X) +get(n / Q-Y));
    }
}
