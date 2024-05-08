package TIL.review;

import java.util.*;
import java.io.*;
public class J11689 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

    long value = Long.parseLong(buffer.readLine());
    long result = value;

    for(long i = 2; i <= Math.sqrt(value); i++){
        if(value%i == 0){
            result = result - result/i;
            while(value%i == 0){
                value = value/i;
            }
        }
    }
    if(value >1 )
        result = result - result/value;
        System.out.println(result);

    }
}
