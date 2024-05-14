package TIL.review;

import java.util.*;
import java.io.*;

public class J1717 {
    static LinkedList<Integer> A;
    static int[] list;


    public static void main(String[]args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        list = new int[N+1];
        for(int i =0; i<=N; i++){
            list[i] = i;
        }

        for(int i = 1; i<= M; i++){
            input = buffer.readLine().split(" ");
            int key = Integer.parseInt(input[0]);
            int a = Integer.parseInt(input[1]);
            int b = Integer.parseInt(input[2]);

            int x = Math.min(a, b);
            int y = Math.max(a, b);
            x = find(x);
            y = find(y);

            if(key == 0){
                union(x, y);
            }

            else{
                if(x != y){
                    System.out.println("NO");
                }else  System.out.println("YES");
            }
        }

    }
    public static void union(int min, int max){
        if(list[max] != list[min]){
            list[max] = list[min];
        }
    }

    public static int find(int num){
        if(list[num] != num)
            return list[num] = find(list[num]);
        return num;
    }

}
