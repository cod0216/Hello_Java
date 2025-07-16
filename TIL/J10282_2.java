package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class J10282_2 {
    static int T, n, d, c;
    static int[] dist;
    static boolean[] visited;
    static BufferedReader buffer;
    static LinkedList<int[]>[] dependencyList;


    public static void main(String[] args) throws IOException {
         initializeBuffer();

        T = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < T; i++) {
            setInputValues();
            setListValue();
            dijstra();
        }
    }

    private static void dijstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{c, 0});

        dist[c] = 0;

        int time = 0;
        int count = 0;
        int computer=c;

        while(!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;

            for(int[] now : dependencyList[cur[0]]){
                if(dist[now[0]] > dist[cur[0]] + now[1]) {
                    dist[now[0]] = dist[cur[0]] + now[1];
                    pq.offer(new int[]{now[0], dist[now[0]]});
                }
            }
            count++;
            computer = cur[0];
        }

        System.out.println(count + " " + dist[computer]);
    }

    private static void initializeBuffer() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    private static void setInputValues() throws IOException {
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        d = Integer.parseInt(input[1]);
        c = Integer.parseInt(input[2]);
    }

    private static void setListValue() throws IOException {
        dependencyList = new LinkedList[n+1];
        dist = new int[n+1];
        visited = new boolean[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i = 1 ; i <= n; i++){
            dependencyList[i] = new LinkedList<>();
        }

        for (int i = 0; i < d; i++) {
            String[] input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[1]);
            int end = Integer.parseInt(input[0]);
            int second = Integer.parseInt(input[2]);

            dependencyList[start].add(new int[]{end, second});
        }

    }
}
