package TIL;

import java.io.*;
import java.util.*;

public class J1948 {
    static int n, m, arr[],dis[];
    static LinkedList<int[]>[] front;
    static LinkedList<int[]>[] back;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        m = Integer.parseInt(buffer.readLine());
        arr = new int[n+1];
        dis = new int[n+1];
        front = new LinkedList[n+1];
        back = new LinkedList[n+1];

        for(int i = 0; i<= n; i++){
            front[i] = new LinkedList<>();
            back[i] = new LinkedList<>();
        }

        String[] input;
        for(int i = 0; i < m; i++){
            input = buffer.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int wight = Integer.parseInt(input[2]);

            front[start].add(new int[]{end, wight});
            arr[end]++;
            back[end].add(new int[]{start, wight});
        }
        input = buffer.readLine().split(" ");
        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        polo(start);
        int ans = poloReverse(end);
        System.out.println(dis[end]);
        System.out.println(ans);
    }
    public static void polo(int start){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int[] now : front[cur]){
                arr[now[0]]--;
                dis[now[0]] = Math.max(dis[now[0]], dis[cur]+now[1]);
                if(arr[now[0]] ==0 ){
                    queue.offer(now[0]);
                }
            }
        }// queue while end
    }
    public static int poloReverse(int end){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(end);
        int cnt=0;
        boolean[] visited = new boolean[n+1];
        visited[end] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int[] now : back[cur]){
                if(dis[cur] == dis[now[0]]+now[1]){
                    cnt++;
                    if(!visited[now[0]]){
                        queue.offer(now[0]);
                        visited[now[0]] = true;
                    }
                }
            }
        }// queue while end
        return cnt;
    }
}
