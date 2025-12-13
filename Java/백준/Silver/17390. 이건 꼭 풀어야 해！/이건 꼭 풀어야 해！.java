import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] arr = new int[N];
        int[] sum = new int[N+1];
        
        input = buffer.readLine().split(" ");
        int s = 0;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(arr);
        
        for(int i = 0; i < N; i++){
            s += arr[i];
            sum[i+1] = s;
        }
        
        for(int i = 0 ; i < M; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0])-1;
            int b = Integer.parseInt(input[1]);
            sb.append(sum[b]- sum[a]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
