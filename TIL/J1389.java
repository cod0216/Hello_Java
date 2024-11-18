package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class J1389 {
    static int arr[], n, m, min,ans;
    static boolean visited[];
    static ArrayList<Integer>[] list;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        n = Integer.parseInt(buffer.readLine());
        m = Integer.parseInt(buffer.readLine());
        min = Integer.MAX_VALUE;
        list = new ArrayList[n+1];

        arr = new int[n+1];


        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            list[s].add(e);
            list[e].add(s);
        }


        System.out.println(BFS(1));
    }

    public static int BFS(int s){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited = new boolean[n+1];
        visited[s] = true;
        int cnt = 0;

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int now : list[cur]){
                if(!visited[now]){
                    visited[now] = true;
                    queue.add(now);
                    cnt++;
                }
            }
        }// queue while end

        return cnt;
    }

}
