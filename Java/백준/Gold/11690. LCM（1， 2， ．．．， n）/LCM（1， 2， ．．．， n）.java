import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    static int idx;
    public static void main(String[] args) throws IOException{
      int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

      boolean[] prime = new boolean[n+1];
      Arrays.fill(prime, true);
      
      prime[0] = prime[1] = false;
      
      for(int i = 2; i<= Math.sqrt(n); i++){
        if(prime[i]){
          for(int j = i*i; j <= n; j = j+i){
            prime[j] = false;
          }
        }
      }
      
        BigInteger m = BigInteger.valueOf(1L << 32);
        BigInteger result = BigInteger.ONE;

        for (int i = 2; i <= n; i++) {
          if (prime[i]) {
          for (long j = i; j <= n; j *= i) {
              result = result.multiply(BigInteger.valueOf(i)).mod(m);
          }
        }
      }

      System.out.println(result.mod(m));
    }
      
}
