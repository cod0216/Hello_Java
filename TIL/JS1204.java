package TIL;

import java.util.*;
import java.io.*;

public class JS1204 {
    static int[] array;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(buffer.readLine());
        int index = Integer.parseInt(buffer.readLine());
        index =0;


        String[] input;

        while(index != num){
            array = new int[100+1];
            input = buffer.readLine().split(" ");
            for(int i =1; i<= 1000; i++) {
                int n = Integer.parseInt(input[i-1]);
                array[n]++;
            }

            int result = findArray(array);
            index++;
            System.out.println("#"+(index) + " " + result);
        }
    }
    public static int findArray(int[] A){

        int max = 0;
        int maxIndex = 0;
        for(int i = 1; i <=100; i++){
            if(max <= A[i]){
                max = A[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
