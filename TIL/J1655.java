package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J1655 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int k= 0;
        n = Integer.parseInt(buffer.readLine());
        PriorityQueue<Integer> list = new PriorityQueue<>(Comparator.comparingInt(o->o));
        PriorityQueue<Integer> temp = new PriorityQueue<>(Comparator.comparingInt(o->o));
        LinkedList<Integer> arr = new LinkedList<>();
        for(int i = 0 ; i < n; i++){
            int size = 0;
            int num= Integer.parseInt(buffer.readLine());
            if(temp.size() == 0){
                list.add(num);
                size = list.size();
                for(int j = 0; j< size; j++){
                    int tempNum= list.poll();
                    arr.add(tempNum);
                    temp.offer(tempNum);
                }
            }
            if(list.size() == 0){
                temp.add(num);
                size = temp.size();
                for(int j = 0; j< size; j++){
                    int tempNum= temp.poll();
                    arr.add(tempNum);
                    list.offer(tempNum);
                }
            }



            if(size <3) {
                if (list.size() == 1 || temp.size() == 1) ans = arr.get(0);
                else if (list.size() == 2 || temp.size() == 2) ans = Math.min(arr.get(0), arr.get(1));
            }else{
                if(list.size()%2 == 0 || temp.size()%2 == 0){
                    ans = Math.min(arr.get(size/2), arr.get(size/2-1));
                }
                else {
                    ans = arr.get(k/2);
                }
            }

            k++;
            System.out.println(ans);
            arr.clear();

        }
    }
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class J1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());

        // 최대 힙 (왼쪽 절반)
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        // 최소 힙 (오른쪽 절반)
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(buffer.readLine());

            // 1. 값 추가
            if (leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.offer(num);
            } else {
                rightHeap.offer(num);
            }

            // 2. 힙 균형 맞추기
            if (leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.offer(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.offer(rightHeap.poll());
            }

            // 3. 중간값 출력 (최대 힙의 루트 값)
            result.append(leftHeap.peek()).append("\n");
        }

        System.out.print(result);
    }
}

 */
