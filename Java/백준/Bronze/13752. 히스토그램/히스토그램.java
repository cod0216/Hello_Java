import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = buffer.readLine();
        
        int N = Integer.parseInt(input);
        for(int i = 0; i< N; i++){
            int n = Integer.parseInt(buffer.readLine());
            for(int j = 0 ; j< n; j++){
                System.out.print("=");
            }
            System.out.println();
        }

    }
}
