package TIL;
import java.util.*;
import java.io.*;

public class J1021 {
    static LinkedList<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int max = Integer.parseInt(input[1]);

        deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.offer(i + 1);
        }

        input = buffer.readLine().split(" ");
        int[] result = new int[n];

        for (int i = 0; i < max; i++) {
            result[i] = Integer.parseInt(input[i]);
        }

        int  cnt=0;
        for(int i = 0 ; i < max; i++) {
            int index;
            if(deque.size() % 2 == 0) {
                index = deque.size() / 2 - 1;
            }
            else {
                index = deque.size() / 2;
            }

            int target = result[i];
            int index1 =  deque.indexOf(target);
            if (index1 <= index) {
                for (int j = 0; j <index1; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                }
            } else {
                for (int j = 0; j < deque.size() - index1; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    cnt++;
                }

            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
