package TIL;

import java.util.*;
import java.io.*;
public class J10986_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        long N = Integer.parseInt(input[0]);
        long key = Integer.parseInt(input[1]);

        long[] array = new long[(int)N+1];
        long[] cntBox = new long[(int)key];

        long total = 0;
        long result;
        input = buffer.readLine().split(" ");

        for(long i = 1; i <= N; i++) {
            array[(int)i] = Integer.parseInt(input[(int)i-1]);
            total += array[(int)i];
            cntBox[(int)(total % key)] +=1;
        }

        result = (int)cntBox[0];

        for(long i = 0; i <key; i++){
            if(cntBox[(int)i]>1){
                result += (cntBox[(int)i]*(cntBox[(int)i]-1))/2;
            }
        }
        System.out.println(result);
    }
}
