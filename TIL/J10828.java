package TIL;

import java.io.*;
import java.util.*;

public class J10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int num = Integer.parseInt(buffer.readLine());
        for(int i = 0 ; i < num; i++) {
            String[] input = buffer.readLine().split(" ");
            String value = input[0];
            switch(value){
                case "push":
                    stack.push(Integer.parseInt(input[1]));
                    break;
                case "pop":
                    if(stack.size() ==0){
                        System.out.println(-1);
                    }
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "top":
                    if(stack.peek() == null) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
                case "empty":
                    if(stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
            }
        }
    }
}
