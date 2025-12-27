import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        
        int ans = rev(rev(a)+rev(b));
        
        System.out.println(ans);
    }
    public static int rev(int n){
        int res = 0;
        while(n > 0){
            res = res * 10 + n%10;
            n = n/10;
        }
        return res;
    }
}
