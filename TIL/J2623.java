package TIL;

import java.io.*;
import java.util.*;

/*
 * find(a) ==find(b) 싸이클 존재
 */
public class J2623 {
    static LinkedList<Integer>[] list;
    static int m, n, arr[];

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n+1];
        list = new LinkedList[n+1];

        for(int i = 0 ;  i<= n; i++ ) {
            list[i] = new LinkedList<>();
        }

        for(int i = 0; i<m; i++) {
            input = buffer.readLine().split(" ");
            int index = Integer.parseInt(input[0]);
            for(int j= 0; j<index-1; j++) {
                int n1 = Integer.parseInt(input[1+j]);
                int n2 = Integer.parseInt(input[2+j]);

                list[n1].add(n2);
                arr[n2]++;
            }
        } //input end

        polo();

    }

    public static void polo() {
        ArrayList res  = new ArrayList();
        Queue<Integer> queue = new LinkedList<>();

       for(int i = 1; i <= n; i++){
            if(arr[i] == 0) queue.offer(i);
       }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            res.add(cur);
            for(int now : list[cur]){
                arr[now]--;
                if (arr[now] == 0) {
                    queue.offer(now);
                }
            }
        } // queue while end

        if(res.size() != n){
            System.out.println(0);
        }else{
            for (Object re : res) {
                System.out.println(re);
            }
        }
    }
}
