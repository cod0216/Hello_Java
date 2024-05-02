package TIL.review;

import java.util.*;
import java.io.*;

public class J1744 {
    static PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minusQueue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int index= Integer.parseInt(buffer.readLine());

        for(int i =0; i < index; i++){
            int num = Integer.parseInt(buffer.readLine());

            if(num >0) plusQueue.add(num);
            else minusQueue.add(num);
        }
        int sum = 0;


        while(!plusQueue.isEmpty()){
            int value = plusQueue.poll();
            if(value == 1){
                sum += value;
            }else if(plusQueue.size()>0){
                int value2 = plusQueue.poll();
                if (value2 == 1){
                    sum += value + value2;
                }
               else sum += value * value2;
            }else sum += value;
        }
        while(!minusQueue.isEmpty()){
            int value = minusQueue.poll();
            if(minusQueue.size()>0) {
                int value2 = minusQueue.poll();
                sum += value2*value;
            }
            else sum += value;
        }
        System.out.println(sum);
    }
}
