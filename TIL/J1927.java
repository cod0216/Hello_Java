package TIL;

import java.io.*;
import java.util.*;

public class J1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int num = Integer.parseInt(buffer.readLine());
        for(int i = 0; i<num; i++ ){
            int value = Integer.parseInt(buffer.readLine());
            if(value == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else System.out.println(pq.poll());
            }else pq.offer(value);
        }
    }
}
