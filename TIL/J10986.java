package TIL;

import java.io.*;
import java.util.*;

public class J10986 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);

        input = buffer.readLine().split(" ");
        int[] num = new int[n];

        for (int i = 0; i <n; i++) {
            num[i] = Integer.parseInt(input[i);
        }

        int start = 0;
        int end = n-1;

        while(end<n && start<end){
            if( start ==end-1)
                start+1;


        }
    }
}
