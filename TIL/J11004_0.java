package TIL;

import java.io.*;
import java.util.*;



public class J11004_0 {
    static ArrayList<Integer> A;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int num = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1])-1;
        A = new ArrayList<>(num);
        input = buffer.readLine().split(" ");

        for (int i = 0; i < num; i++) {
            A.add(Integer.parseInt(input[i]));
        }
        Collections.sort(A);

        System.out.println(A.get(key));
    }
}
