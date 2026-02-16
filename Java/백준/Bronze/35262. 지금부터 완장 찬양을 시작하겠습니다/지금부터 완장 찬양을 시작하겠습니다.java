import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    String[] input = buffer.readLine().split(" ");
    
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);
    
    int ans = 1;
    int cnt = 0;
    input = buffer.readLine().split("");
    for(int i = 0 ; i < N ; i++){
      int v = Integer.parseInt(input[i]);
      if(v == 0) cnt++;
      else cnt = 0;
      
      if(cnt == K) ans = 0;
    }
    
    System.out.println(ans);
  }
}