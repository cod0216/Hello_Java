package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10464 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;
        while(T > t){
            int ans = 1;
            String[] input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int f = Integer.parseInt(input[1]);
            int sum = 1;
            for(int i = 1; i < s; i++){
                sum^=i;
            }
            for(int i = 1; i <= f; i++){
                ans^=i;
            }

             ans = ans^sum;
            t++;
            System.out.println(ans);
        }




    }

    public static void print(int num){
        System.out.println(String.format("%s", Integer.toBinaryString(num)));
    }
}
