package TIL;

import java.io.*;
import java.util.*;

public class J1744 {
    static int dummy = 0;
    static int dummyA = 0;
    static int dummyB = 0;

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> nqueue = new PriorityQueue<>();


        int index = Integer.parseInt(buffer.readLine());
        int cnt = 0;
        int cntKey = -1;
        int ncnt = 0;


        for (int i = 0; i < index; i++) {
            int value = Integer.parseInt(buffer.readLine());

            if(value > 0)
                pqueue.add(value);

            else if(value<0){ nqueue.add(value);
                ncnt++;
            }
            else {
                cntKey=1;
                cnt++;
            }
        }
        int sum = 0;
        while(!pqueue.isEmpty()) {
            int a = pqueue.poll();
            int b = 0;
            if (!pqueue.isEmpty()) {
                b = pqueue.poll();
            }

            if (a == 1 || b ==1 ) sum += a + b;
            else if ((a * b) <= 0) sum += (a + b);
            else sum += (a * b);
            //-------------------------
        }
        while(!nqueue.isEmpty()){
            int a = nqueue.poll();
            ncnt--;
            int b = 0;
            if (ncnt == cnt) {
                    b = 0;
                    cnt--;
            }
            else if(!nqueue.isEmpty()){
            b = nqueue.poll();
                ncnt--;
            }
            if(b == 0 && cntKey == -1) sum += a+b;
            else sum += (a*b);
        }
        if(cnt == 0){
            cntKey = -1;
        }
        System.out.println(sum);
    }
}
