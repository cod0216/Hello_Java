import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = buffer.readLine().split(" ");
        
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        
        if(Math.min(x,y) == 0) System.out.println(Math.max(x,y));
        
        System.out.println(x + y - gcd(x,y));
        
        
    }
    
    public static int gcd(int a, int b){
      return b == 0 ? a : gcd(b, a % b);
    }
    
}
