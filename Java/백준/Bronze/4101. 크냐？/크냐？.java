import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        while(true){
            String[] input = buffer.readLine().split(" ");
        
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);            
            if(N == 0 && M == 0) break;
            System.out.println(N > M ? "Yes" : "No");
        }

    }
}
