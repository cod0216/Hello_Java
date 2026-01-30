import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");
        
        int state = 0;
        int max = 0;
        int[] arr = new int[10];
        int num = 0;
        
        for(int i = 0 ; i < input.length; i++){
            int v = Integer.parseInt(input[i]);
            arr[v] += 1;
            if(v == 6 || v == 9) state += 1;
            else max = Math.max(max, arr[v]);
        }
        
        if(state %2 == 0) state = state/2;
        else state = state/2 + 1;
        
        if(max > state) System.out.println(max);
        else System.out.println(state);

    }
}
