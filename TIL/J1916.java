package TIL;

import java.io.*;
import java.util.*;

/*
N개 도시 M개 버스
A -> B 까지 가는 최소 비용 (양수)
따악 봐도 다잌

[입력]
N
M
버스 정보
start end
 */

class Node1916 implements Comparable<Node1916>{
    int e;
    int w;

    public Node1916(int e, int w) {
        this.e = e;
        this.w = w;
    }

    @Override
    public int compareTo(Node1916 o) {
        return this.w - o.w;
    }
}
public class J1916 {
    static int start, end, n, m, arr[];
    static LinkedList<Node1916>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        m = Integer.parseInt(buffer.readLine());
        list = new LinkedList[n+1];
        visited = new boolean[n+1];
        arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);

        for(int i = 0; i<= n; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 0 ; i< m; i++){
           String[] input = buffer.readLine().split(" ");
           int s = Integer.parseInt(input[0]);
           int e = Integer.parseInt(input[1]);
           int w = Integer.parseInt(input[2]);

           list[s].add(new Node1916(e, w));
        }
        String[] input = buffer.readLine().split(" ");
        start = Integer.parseInt(input[0]);
        end = Integer.parseInt(input[1]);
        // input end;

        dijkstra(start, end);
        System.out.println(arr[end]);
    }
    public static void dijkstra(int s, int e){
        PriorityQueue<Node1916> pq = new PriorityQueue();
        pq.offer(new Node1916(s, 0));
        arr[s] = 0;
        while(!pq.isEmpty()){
            Node1916 nowNode = pq.poll();
            int now = nowNode.e;
            if(!visited[now]) {
                visited[now] = true;
                for (Node1916 node : list[now]) {
                    if (!visited[node.e] && arr[node.e] > arr[now] + node.w) {
                        arr[node.e] = arr[now] + node.w;
                        pq.offer(new Node1916(node.e, arr[node.e]));
                    }
                }
            } // node for end
        }// pq while end
    }

}
