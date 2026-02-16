import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    int ans = 0;
    
    int N = Integer.parseInt(buffer.readLine());
    
    int[] A = new int[46];
    int[] B = new int[46];
    
    A[0] = 1;
    
    for(int i = 0; i <45; i++){
      int a = B[i];
      int b = B[i] + A[i];
      
      A[i+1] = a;
      B[i+1] = b;
    }
    
    
    System.out.println(A[N] + " " + B[N]);
  }
}