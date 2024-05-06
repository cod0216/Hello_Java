package TIL;

import java.util.*;
import java.io.*;

public class J11689 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        long num = Long.parseLong(buffer.readLine());
        long result = num;

        for(long i = 2; i <Math.sqrt(num); i++){
            if(num % i == 0 ) {
                
                result = result - result/i;
                while(num % i == 0){
                    num = num / i;
                }

            }
        }
        if(num>1){
            result = result -result/num;
        }
        System.out.println(result);

    }
}
