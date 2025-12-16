import java.util.*;
import java.io.*;

public class Main {
    static long N;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(buffer.readLine());
        dfs(0, 1, 0);
    }
    
    public static void dfs(long a, long b, int cnt){
        if(cnt == N){
            System.out.println(a);
            return;
        }
        dfs(b, a+b, cnt+1);
    }
    
}
