package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class J11286 {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            int num1 = Math.abs(o1);
            int num2 = Math.abs(o2);
            if(num1 == num2){
                return o1 - o2;
            }
            return num1 - num2; // -1 값이면 o1이 우선순위다.
        });
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i <number; i++){
            int value = Integer.parseInt(bufferedReader.readLine());
            if( value == 0){
                if(priorityQueue.size() == 0)
                    System.out.println("0");
                else
                    System.out.println(priorityQueue.poll());
            }
            else priorityQueue.add(value);
        }
    }
}
