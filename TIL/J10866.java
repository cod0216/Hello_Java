package TIL;

import java.util.*;
import java.io.*;

public class J10866 {
    public static Deque<Integer> deque;
    public static void main(String[] args)throws IOException {
        deque = new ArrayDeque<>();

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n =Integer.parseInt(buffer.readLine());
        for(int i = 0 ; i <n ; i++) {
            String[] input = buffer.readLine().split(" ");
            functionDe(input);
        }

    }
    public static void functionDe(String[] input) {
        switch(input[0]){
            case "push_front":
                deque.offerFirst(Integer.parseInt(input[1]));
                break;
            case "push_back":
                deque.offerLast(Integer.parseInt(input[1]));
                break;
            case "front":
                if(deque.isEmpty()){
                    System.out.println(-1);
                } else System.out.println(deque.peekFirst());
                break;
            case "back":
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else System.out.println(deque.peekLast());
                break;
            case "size":
                System.out.println(deque.size());
                break;
            case "pop_front":
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else System.out.println(deque.pollFirst());
                break;
            case "pop_back":
                if(deque.isEmpty()){
                    System.out.println(-1);
                }else System.out.println(deque.pollLast());
                break;
            case "empty":
                if(deque.isEmpty()){
                    System.out.println(1);
                }else System.out.println(0);
                break;
        }

    }
}
