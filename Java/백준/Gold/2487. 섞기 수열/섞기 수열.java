import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        int[] arr = new int[N+1];
        
        for(int i = 1 ; i <= N; i++){
            arr[i] = Integer.parseInt(input[i-1]);
        }
        
        boolean[] visited = new boolean[N+1];
        HashSet<Integer> set = new HashSet<>();
        for(int i = 1; i <= N; i++){
            if(visited[i]) continue;

            visited[i] = true;
            int now = arr[i];
            int cnt = 1;
            
            while(now != i){
                visited[now] = true;
                cnt++;
                now = arr[now];

            }
            set.add(cnt);
        }
        
        long result = 1;
        for(int e : set) result = lcm(result, (long)e);
        
        System.out.println(result);
    }
    
    public static int lcm(long a, long b){
        long gcd;
        if(a > b) gcd = gcd(a, b);
        else gcd = gcd(b, a);
        
        return (int)((a*b)/gcd);
    }
    
    public static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a%b);
    }
}
