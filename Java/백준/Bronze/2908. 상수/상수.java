import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input[] = buffer.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        
        for(int i = 2; i >= 0; i--){
            sb.append(input[0].charAt(i));
        }
        int A = Integer.parseInt(sb.toString());
        
        sb = new StringBuilder();
        for(int i = 2; i >= 0; i--){
            sb.append(input[1].charAt(i));
        }
        int B = Integer.parseInt(sb.toString());
        
        System.out.println(A > B ? A : B);
    }
}
