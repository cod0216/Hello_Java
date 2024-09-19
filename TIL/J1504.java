package TIL;
import java.io.*;
import java.util.*;



/*
 * 방향성 없는 그래프( 양방향)
 * 1번 정점에서 N번 정점으로 최단 거리로 이동
 * 임의로 주어진 두 정점은 반드시 통과
 *
 * dijkstra
 */

class Node implements Comparable<Node>{
    public int end;
    public int w;

    public Node(int end, int w) {
        this.end = end;
        this.w = w;
    }

    public int compareTo(Node o) {
        return this.w - o.w;
    };
}

public class J1504 {
    static LinkedList<Node>[] list;
    static int n, e, distance[];

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        e = Integer.parseInt(input[1]);

        list = new LinkedList[n+1];

        for(int i = 1; i<= n; i++) {
            list[i]= new LinkedList<>();
        }

        for(int i = 0; i< e; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int wight = Integer.parseInt(input[2]);

            list[start].add(new Node(end, wight));
            list[end].add(new Node(start, wight));

        }
        input = buffer.readLine().split(" ");
        int mid1 = Integer.parseInt(input[0]);
        int mid2 = Integer.parseInt(input[1]);
        //input end

        int a = dijkstra(1, mid1);
        int b = dijkstra(mid1, mid2);
        int c = dijkstra(mid2, n);
        int res1 = a + b + c;
        if(a == Integer.MAX_VALUE || b == Integer.MAX_VALUE || c == Integer.MAX_VALUE) {
            res1 = -1;
        }

        int e = dijkstra(1, mid2);
        int f = dijkstra(mid2, mid1);
        int g = dijkstra(mid1, n);
        int res2 = e + f + g;
        if(e == Integer.MAX_VALUE || f == Integer.MAX_VALUE || g == Integer.MAX_VALUE) {
            res2 = -1;
        }

        System.out.println(Math.min(res1,res2));

    } // main end
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        queue.offer(new Node(start,0));

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            int node = cur.end;
            if(!visited[node]) {
                visited[node] = true;
                for(Node now : list[node]) {
                    if(distance[now.end] > distance[node] + now.w) {
                        distance[now.end] = distance[node] + now.w;
                        queue.offer(new Node(now.end, distance[now.end]));
                    }
                }
            }
        } // while end

        return distance[end];
    }

}



