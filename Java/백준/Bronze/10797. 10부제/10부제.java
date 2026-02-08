import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int[] arr = new int[5];
        int cnt = 0;
        String[] input = buffer.readLine().split(" ");
        for(int i = 0 ; i < 5; i++){
            int v = Integer.parseInt(input[i]) % 10;
            if(v == N) cnt++;
        }
        System.out.println(cnt);
    }
}
