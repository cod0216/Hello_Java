package TIL;

import java.io.*;
import java.util.*;

public class J15787_1 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int[] train = new int[n+1];
        int m = Integer.parseInt(input[1]);

        while(m-->0){
            input = buffer.readLine().split(" ");

            int c = Integer.parseInt(input[0]);
            int a, b;

            switch (c) {
                case 1 :
                    a = Integer.parseInt(input[1]);
                    b = Integer.parseInt(input[2]);
                    train[a] |= (1 << b);
                    break;

                case 2 :
                    a = Integer.parseInt(input[1]);
                    b = Integer.parseInt(input[2]);
                    train[a] &= ~(1 << b);
                    break;
                case 3 :
                    a = Integer.parseInt(input[1]);
                    train[a] &= ~(1 << 20);
                    train[a] <<= 1;
                    break;
                case 4 :
                    a = Integer.parseInt(input[1]);
                    train[a] &= ~(1 << 1);
                    train[a] >>= 1;
                    break;
            }
        }

        HashSet<Integer> list = new HashSet<>();
        for(int i = 1 ; i<=n ; i ++) list.add(train[i]);
        System.out.println(list.size());
    }
}
