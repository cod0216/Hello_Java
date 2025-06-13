package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class J1158_1 {
    static LinkedList<Integer> list;
    public static void main(String[] args) throws IOException {
        list = new LinkedList<>();
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int k = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[0]);

        for(int i = 1; i <= k; i++){
            list.add(i);
        }

    }
}
