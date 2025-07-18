package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;

public class J13335 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer  = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);


        String[] car = buffer.readLine().split(" ");
        LinkedList<Integer> queue = new LinkedList<>();
        LinkedList<Integer> bridge = new LinkedList<>();
        int length = car.length;
        int idx= 0;

        while(length>idx){
            queue.offer(Integer.parseInt(car[idx]));
            idx++;
        }
        int time = 0;
        int weight = 0;

        for (int i = 0; i < W; i++) {
            bridge.offer(0);
        }

        while(!bridge.isEmpty()){
            time++;
            weight -= bridge.poll();
            if(!queue.isEmpty()){
                if(queue.peek() + weight <= L){
                    weight += queue.peek();
                    bridge.offer(queue.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }
        System.out.println(time);
    }
}
