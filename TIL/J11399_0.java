package TIL;

import java.io.*;
import java.util.*;


public class J11399_0 {
    static LinkedList<Integer> A;
    static int max;
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        A = new LinkedList<>();
        for(int i =0; i <num; i++){
            A.add(Integer.parseInt(input[i]));
        }

        Collections.sort(A);

        int[] sum = new int[num+1];
        int total = 0;

        for(int i = 1; i<= num; i++){
            sum[i] = sum[i-1]+A.get(i-1);
            total += sum[i];
        }

        System.out.println(total);
    }
}
