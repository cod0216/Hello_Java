package TIL.review;
import java.util.*;
import java.io.*;

public class J1715 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue();
        int index = Integer.parseInt(buffer.readLine());

        for (int i = 0; i < index; i++) {
            pq.add(Integer.parseInt(buffer.readLine()));
        }
        int total = 0;
        while(!pq.isEmpty()){
            int a = pq.poll();
            if(pq.size()>0){
                int b = pq.poll();
                total += a+b;
                pq.add(a+b);
            }
        }
        System.out.println(total);


    }
}
