package TIL.review;

import java.util.*;
import java.io.*;

public class J1715_0 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(buffer.readLine());
        int sum = 0;
        for(int i = 0; i< N; i++){
            queue.add(Integer.parseInt(buffer.readLine()));
        }

        int result=0;

        int A = 0;
        int B = 0;
        while(!queue.isEmpty()){
            A = queue.poll();
            if(queue.isEmpty()) {
                B = 0;
//                result += A;
                break;
            }
            B = queue.poll();
            sum = A+B;
            queue.add(sum);
            result += sum;
        }
        System.out.println(result);

    }
}
