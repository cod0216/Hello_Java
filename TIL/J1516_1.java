package TIL;

import java.io.*;
import java.util.*;

public class J1516_1 {
    static int F, countArr[], timeArr[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        F = Integer.parseInt(buffer.readLine());
        int f = 0;
        countArr = new int[F+1];
        timeArr = new int[F+1];

        list = new ArrayList[F+1];
        for(int i = 0; i <= F; i++){
            list[i] = new ArrayList<>();
        }

        while(F >f){
            String[] input= buffer.readLine().split(" ");
            int size = input.length-2;
            timeArr[f+1] = Integer.parseInt(input[0]);
            for(int i = 0; i < size; i++){
                int n = Integer.parseInt(input[i+1]);
                list[n].add(f+1);
                countArr[f+1]++;
            }
            f++;
        }

        polo();
    }

    public static void polo(){
        int[] res = new int[F+1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= F; i++){
            res[i]=timeArr[i];
            if(countArr[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int now : list[cur]){
                countArr[now]--;
                res[now] = Math.max(res[now], res[cur] + timeArr[now]);
                // ??
                if(countArr[now] == 0){
                    queue.offer(now);
                }
            }
        }
        for(int i = 1 ; i<=F; i++ ){
            System.out.println(res[i]);
        }
    }
}
