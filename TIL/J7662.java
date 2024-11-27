package TIL;

import java.io.*;
import java.util.*;

/*
이중 우선순위 큐는 전형적인 우선순위 큐처럼 데이터를 삽입, 삭제할 수 있는 자료구조
전형적인 큐와의 차이점
데이터를 삭제할때 연산 명령어에 따라 우선위가 가장 높은 ㄷ게이터 또는 가장 낮은 데이터 중 하나를 삭제한다.

이중 우선 순위 큐를 위해선
두가지 연산 사용 하나는 데이터 삽입하는 연산
하나는 데이터를 삭제하는 연산

데이터 삭제
우선순위 높은거 우선순위 낮은거

 */

public class J7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        String[] input;

        while(T > t) {
            TreeMap<Long, Integer> queue = new TreeMap<>();
            int n = Integer.parseInt(buffer.readLine());
            for(int i = 0; i < n; i++) {
                input = buffer.readLine().split(" ");
                char option = input[0].charAt(0);
                long target = Long.parseLong(input[1]);

                switch (option) {
                    case 'I':
                        queue.put(target, queue.getOrDefault(target, 0) + 1);
                        break;
                    case 'D':
                        if (queue.isEmpty()) {
                            break;
                        }
                        if (target == -1) {

                            if (queue.get(queue.firstKey()) == 1) {
                                queue.remove(queue.firstKey());
                            } else {
                                queue.put(queue.firstKey(), queue.get(queue.firstKey()) - 1);
                            }
                        } else if (target == 1) {

                            if (queue.get(queue.lastKey()) == 1) {
                                queue.remove(queue.lastKey());
                            } else {
                                queue.put(queue.lastKey(), queue.get(queue.lastKey()) - 1);
                            }
                        }
                        break;
                }
            }

            if (queue.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(queue.lastKey() + " " + queue.firstKey());
            }
            t++;
        }
    }
}
