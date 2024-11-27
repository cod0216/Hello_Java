package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10250 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());


        for(int i = 0 ; i < n; i++){

            String[] input = buffer.readLine().split(" ");
            int H = Integer.parseInt(input[0]);
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]);

           int Y = (N-1)%H+1;
           int X = (N-1)/H+1;
           System.out.println(Y*100+X);
        }





    }
}
