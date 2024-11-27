package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J1655 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());


        PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(buffer.readLine());


            if(left.size() == right.size()) left.offer(num);
            else right.offer(num);


            if(!right.isEmpty() && !left.isEmpty()){
                if(right.peek() <left.peek() ){
                    int temp = right.poll();
                    right.offer(left.poll());
                    left.offer(temp);
                }

            }
            result.append(left.peek()).append("\n");
        } // for end

        System.out.print(result);
    }
}