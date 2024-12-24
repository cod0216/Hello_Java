package TIL;

import java.io.*;
import java.util.*;


public class J2252_3 {
    static int n, m, arr[];
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]); m = Integer.parseInt(input[1]);
        list = new ArrayList[n+1];
        arr = new int[n+1];

        for(int i = 0; i<=n; i++) list[i] = new ArrayList<>();


        for(int i = 0; i< m; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]); int end = Integer.parseInt(input[1]);

            list[start].add(end);
            arr[end]++;
        }

        polo();
    }

    public static void polo(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            if(arr[i] == 0) queue.offer(i);
        }

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int cur = queue.poll();
                System.out.print(cur + " ");
                for(int now : list[cur]){
                    arr[now]--;
                    if(arr[now] == 0){
                        queue.offer(now);
                    }
                }
            }
        } // queue while end
    }
}
