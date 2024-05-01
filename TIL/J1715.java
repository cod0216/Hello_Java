package TIL;

import java.io.*;
import java.util.*;

public class J1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int key= Integer.parseInt(buffer.readLine());
        PriorityQueue<Integer> pqueue1 = new PriorityQueue<>();

        for (int i = 0; i < key; i++) {
            pqueue1.add(Integer.parseInt(buffer.readLine()));
        }
        int sum = 0;
        while(pqueue1.size()>1){
           int a = pqueue1.poll();
           int b = pqueue1.poll();
                                        // 우선순위 큐활용을 배웠지만 수리 부분에 대해서 분석을 정홛하게 하지 못했음 -> 문제 이해가 안된건지 분석이 안된건지 메타인지가 잘 안됨
                                        // 이게 그리드니까 어쩌면 그 부분을 잘 생각해서 복습 해보자
           sum += a+b;
           pqueue1.add(a+b);
        }
        System.out.println(sum);
    }
}



//https://puk0806.tistory.com/3