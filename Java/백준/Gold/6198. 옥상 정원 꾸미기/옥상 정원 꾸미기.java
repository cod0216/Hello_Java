import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        
        int[] build = new int[N];
        int[] ans = new int[N];
        int cnt = 0;
        
        for(int i = 0; i < N; i++){
          build[i] = Integer.parseInt(buffer.readLine());  
        }
        int before = Integer.MAX_VALUE;
        LinkedList<Integer> stack = new LinkedList<>();
        
        // 10 3 7 4 12 2
        // 12 7 12 12 -1 -1
        for(int i = 0; i < N; i++){
          while(!stack.isEmpty() && build[stack.peek()] <= build[i]){
            build[stack.pop()] = i;
          }
          stack.push(i);
        }
        while(!stack.isEmpty()){
          build[stack.pop()] = -1;
        }
        
        // for(int i = 0; i < N; i++){
          // System.out.print(build[i] + " ");
        // }
        
        long res = 0;
        
        for(int i = 0; i < N; i++){
          if(build[i] == -1){
            res += N - i-1;
          }else{
            res = res + build[i] - i-1;
          }
        }
        System.out.println(res);
    }
}
