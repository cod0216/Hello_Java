import java.util.*;
import java.io.*;

public class Main {
    static int idx;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int[] box = new int [N];
        box = isPrime(N);
        
        int[] sumBox = new int[idx+1];
        int sum = 0;
        for(int i = 1; i<= idx; i++){
          sum = sum + box[i-1];
          sumBox[i] = sum;
        }
        
        int start = 0;
        int end = 1;
        int cnt = 0;
        
        while(start < end && end <= idx){
          int v = sumBox[end] - sumBox[start];
          if( v < N){
            end++;
          } 
          else if(v >= N){
            if(v == N){
              cnt++;
            }
            start++;
          }
        }
        System.out.println(cnt);
        
        
    }
    public static int[] isPrime(int n){
      boolean[] prime = new boolean[n+1];
      int[] box = new int[n+1];
      
      Arrays.fill(prime, true);
      prime[0] = prime[1] = false;
      
      for(int i = 2; i <= Math.sqrt(n); i++){
        if(prime[i]){
          for(int j = i*i; j <= n; j +=i){
            prime[j] = false;
          }
        }
      }
      
      for(int i = 0 ; i<= n; i++){
        if(prime[i]){
          box[idx] =i;
          idx++;
        } 
      }
      return box;
    }
}
