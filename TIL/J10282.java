package TIL;

import java.io.*;
import java.util.*;

/*
 * 최흉최악의 해커 윰3이 네트워크 시설 한 콤퓨터 해킹했다.
 * b가 a 의존 하지 않는다면 a가 감영되어도 b는 안전하다
 * 총 몇대 의 텀터가 감염되고 그에 걸리는 시간 얼마인지 구하라
 *
 * 시간-> depth
 *
 * queue 활용해야될듯
 *
 * [입력]
 * Tc
 * 컴터 개수, 의존성 개수, 해킹당한 컴퓨터의 번호(start)
 *
 *
 */
class Computer implements Comparable<Computer>{
    int end;
    int time;



    public Computer(int end, int time) {
        super();
        this.end = end;
        this.time = time;
    }



    public int compareTo(Computer o) {
        return this.time - o.time;
    };

}

public class J10282 {
    static int n, d, start, distance[], cnt, finalEnd;
    static LinkedList<Computer>[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T >t) {
            String[] input = buffer.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            d = Integer.parseInt(input[1]);
            start = Integer.parseInt(input[2]);
            list = new LinkedList[n+1];
            distance = new int[n+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[start] = 0;
            for(int i = 0 ; i <=n; i++) {
                list[i] = new LinkedList<>();
            }

            for(int i = 0; i <d; i++) {
                input = buffer.readLine().split(" ");

                int node = Integer.parseInt(input[1]);
                int end = Integer.parseInt(input[0]);
                int time = Integer.parseInt(input[2]);

                list[node].add(new Computer(end, time));
            }// input end

            dijkstra();
            int maxTime= 0;
            for(int i = 1; i <=n; i++){
                if(distance[i] != Integer.MAX_VALUE)
                    maxTime = Math.max(distance[i],maxTime);
            }
            System.out.println(cnt + " " + maxTime);
            t++;
        } // tc end

    }// main end

    public static void dijkstra() {
        PriorityQueue<Computer> queue = new PriorityQueue<>();
        visited = new boolean[n+1];
        queue.offer(new Computer(start, 0));
        cnt = 0;
        while(!queue.isEmpty()) {
            Computer cur = queue.poll();
            int node = cur.end;
            if(!visited[node]) {
                cnt++;
                visited[node] = true;

                for (Computer now : list[node]) {
                    if (distance[now.end] > distance[node] + now.time) {
                        distance[now.end] = distance[node] + now.time;
                        queue.offer(new Computer(now.end, distance[now.end]));
                    }
                }
            }
        }// queue while end
    }
}
