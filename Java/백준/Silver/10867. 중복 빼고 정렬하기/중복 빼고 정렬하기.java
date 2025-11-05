import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        
        int[] arr = new int[N];
        String[] input =buffer.readLine().split(" ");
        
        for(int i = 0; i < N ; i ++){
            arr[i] = Integer.parseInt(input[i]); 
        }
        Arrays.sort(arr);
        int v = arr[0];
        System.out.print(arr[0] + " ");
        for(int i = 0; i < N ; i ++){        
            if(v == arr[i]) continue;
            System.out.print(arr[i] + " ");            
            v = arr[i];
        }

    }
}
