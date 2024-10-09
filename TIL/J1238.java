package TIL;

import java.io.*;
import java.util.*;

public class J1238 {
    static int n, e, x;
    static int[][] city;
    static ArrayList<int[]>[] list;
    static boolean[] visited;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        list = new ArrayList[n+1];

        for(int i = 0 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }

        city = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            Arrays.fill(city[i],Integer.MAX_VALUE/2);
        }



        for(int i = 0 ; i <e; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);
            list[start].add(new int[]{end,weight});

        }

        for(int k = 1; k <=n; k++){
            for(int i = 1; i <=n; i++){
                for(int j = 1; j <=n; j++){
                    city[i][j] = Math.min(city[i][j],city[i][k] + city[k][j]);
                }
            }
        }

        for(int i = 1; i<=n; i++) {
            dijkstra(i);
        }

        long max = Integer.MIN_VALUE;
        for(int i = 1; i <=n; i++){
            max = Math.max(max, city[i][x] + city[x][i]);
        }
        System.out.println(max);
    } // main end

    public static void dijkstra(int start){
        visited = new boolean[n+1];
        city[start][start] = 0;
        PriorityQueue<int[]> pqueue = new PriorityQueue<>(Comparator.comparingInt(o->o[1]));
        pqueue.offer(new int[] {start, 0});
        while(!pqueue.isEmpty()) {
            int [] cur = pqueue.poll();
            int s = cur[0];
            if(visited[s]) continue;
            visited[s] = true;
            for(int[] now : list[s]){
                if(!visited[now[0]]){
                    if(city[start][now[0]] > city[start][cur[0]]+now[1]){
                        city[start][now[0]] = city[start][cur[0]]+now[1];
                        pqueue.offer(new int[]{now[0], city[start][now[0]]});
                    }
                }
            }
        }// pqeue while end
    }
}
