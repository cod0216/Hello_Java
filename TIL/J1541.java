package TIL;
//import java.util.*;
import java.io.*;

public class J1541 {
    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split("\\-");
        int value = 0;


            for(int i = 0; i < input.length; i ++){
                String[] num = input[i].split("\\+");
                int sum = 0;
                if(i == 0 ) {
                    for (int j = 0; j < num.length; j++) {
                        value += Integer.parseInt(num[j]);
                    }
                }
                else
                {
                    for(int j = 0; j < num.length; j++){
                        sum += Integer.parseInt(num[j]);
                    }
                }
                value = value - sum;

            }


        System.out.println(value);

    }
}
