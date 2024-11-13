package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Bus implements Comparable<Bus> {
    int end;
    int wight;

    public Bus(int end, int wight) {
        this.end = end;
        this.wight = wight;
    }

    @Override
    public int compareTo(Bus o) {
        return this.wight - o.wight;
    }
}

public class J1916_1 {

    static int n,f, dis[];
    static boolean[] visited;

    static ArrayList<Bus>[] list;



    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        f = Integer.parseInt(buffer.readLine());

        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);

        for(int i = 0 ; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0 ; i<f; i++) {
            String[] input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            list[s].add(new Bus(e, w));
        }

        String[] input = buffer.readLine().split(" ");

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);
        // input end

        dijkstra(start, end);

        System.out.println(dis[end]);
    }

    public static void dijkstra(int s, int e){
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        dis[s] = 0;
        pq.offer(new Bus(s,0));
        while(!pq.isEmpty()){
            Bus b= pq.poll();
            int curEnd = b.end;
            if(!visited[curEnd]) {
                visited[curEnd] = true;

                for (Bus bus : list[curEnd]) {
                    int nEnd = bus.end;
                    int nWight = bus.wight;
                    if (!visited[nEnd] && dis[nEnd] > dis[curEnd] + nWight) {
                        dis[nEnd] = dis[curEnd] + nWight;
                        pq.offer(new Bus(nEnd, dis[nEnd]));
                    }
                }
            }
        }// pq while end
    }
}
