package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;




public class J2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String [] input = buffer.readLine().split(" ");

        int moving = Integer.parseInt(input[0]);
        int sliding = Integer.parseInt(input[1]);
        int distance = Integer.parseInt(input[2]);

        int result;

        if((distance - sliding) % (moving - sliding) != 0 ){
            result = (distance - sliding) / (moving - sliding)+1;
        }
        else result = (distance - sliding) / (moving - sliding);
        System.out.println(result);
    }
}
