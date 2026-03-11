import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine());
        
        if (N * N <= 100000000L) {
            System.out.println("Accepted");
        } else {
            System.out.println("Time limit exceeded");
        }
    }
}