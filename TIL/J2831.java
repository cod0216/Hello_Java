package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class J2831 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        PriorityQueue<Integer> upMan = new PriorityQueue<>();
        PriorityQueue<Integer> downMan = new PriorityQueue<>();
        PriorityQueue<Integer> upWoman = new PriorityQueue<>();
        PriorityQueue<Integer> downWoman = new PriorityQueue<>();

        String[] manInput = buffer.readLine().split(" ");
        String[] womanInput = buffer.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(manInput[i]);
            if(num > 0) upMan.offer(Math.abs(num));
            else downMan.offer(Math.abs(num));
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(womanInput[i]);
            if(num > 0) upWoman.offer(Math.abs(num));
            else downWoman.offer(Math.abs(num));
        }

        int upCount = up(upMan, downWoman);
        int downCount = down(downMan, upWoman);

        System.out.println(upCount+downCount);

    }

    private static int up(PriorityQueue<Integer> upMan, PriorityQueue<Integer> downWoman) {
        int count = 0;

        while(!upMan.isEmpty() && !downWoman.isEmpty()){
            int man = upMan.peek();
            int woman = downWoman.peek();

            if(man < woman){
                count++;
                upMan.poll();
                downWoman.poll();
            }else {
                downWoman.poll();
            }
        }

        return count;
    }

    private static int down(PriorityQueue<Integer> downMan, PriorityQueue<Integer> upWoman) {
        int count = 0;

        while(!upWoman.isEmpty() && !downMan.isEmpty()){
            int woman = upWoman.peek();
            int man = downMan.peek();
            if(man > woman){
                count++;
                upWoman.poll();
                downMan.poll();
            }else {
                downMan.poll();
            }
        }
        return count;
    }
}
