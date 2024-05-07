package TIL;

import java.io.*;

public class J11689_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        long key = Long.parseLong(buffer.readLine());

        long count = key;
        long result = key;

        for(long i =2; i<= Math.sqrt(key); i++){
            if(count % i == 0){
                result = result - result/i;
                while(count % i == 0){
                    count /= i;
                }
            }
        }

        if( count>1 ){
            result = result - result/count;
        }

        System.out.println(result);
    }
}
