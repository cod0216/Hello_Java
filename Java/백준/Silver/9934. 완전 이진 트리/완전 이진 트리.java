import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int level = Integer.parseInt(buffer.readLine());
        int idx = (int)Math.pow(2, level) -1;
        int[] list = new int[idx];    
        
        String[] input = buffer.readLine().split(" ");
        for(int i = 0 ; i < input.length; i++){
            list[i] = Integer.parseInt(input[i]);
        }
        int p = idx;
        while(p != 0){
            int child = (p - 1) / 2;
            int gap = (p - child) *2;
            for(int i = child ; i < idx; i = i+gap){
                System.out.print(list[i] + " ");
            }
            p = child;
            System.out.println();
        }
    
    }
}
