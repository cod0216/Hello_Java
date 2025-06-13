package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class J1753_6 {

    public static LinkedList<int[]>[] list;
    public static int[] dist;

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input  = buffer.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[0]);

        list = new LinkedList[a+1];

        int start = Integer.parseInt(buffer.readLine());

        for(int i = 0; i<= a; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 1 ; i <= b ; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[0]);

            list[a].add(new int[]{e,w});
        }

        process();
    }

    public static void process(){

    }
}
