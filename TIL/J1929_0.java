package TIL;
import java.util.*;
import java.io.*;

public class J1929_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int startNum = Integer.parseInt(input[0]);
        int endNum = Integer.parseInt(input[1]);
        int[] array = new int[endNum+1];

        for(int i =0; i<= endNum; i++){
            array[i] = i;
        }
        array[1] = 0;

        for(int i = 2; i <= Math.sqrt(endNum); i++){
            if(array[i] == 0) continue;
            for(int j = i+i; j <= endNum; j=i+j){
                array[j] = 0;
            }
        }

        for(int i = startNum; i <= endNum; i++){
            if( array[i] != 0) System.out.println(array[i]);
        }
    }
}
