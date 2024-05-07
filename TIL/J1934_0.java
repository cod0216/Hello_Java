package TIL;

import java.util.*;
import java.io.*;

public class J1934_0 {
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        for(int i =0; i <n; i++){
            String[] input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int small = Math.min(a, b);
            int large = Math.max(a, b);

            while(large%small != 0){
                int temp = small;
                small = large%small;
                large = temp;
            }
            System.out.println(((a*b)/small));

        }

    }
}
