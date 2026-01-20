import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int C = Integer.parseInt(input[1]);            
            
            if(N%C == 0) System.out.println(N/C);
            else System.out.println(N/C + 1);
            
            t++;
        }
    }
}
