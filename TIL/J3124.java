//package TIL;
//
//import java.io.*;
//import java.util.*;
//    class Node implements Comparable<Noode>{
//        int endNode;
//        long w;
//
//        public Node(int endNode, long w){
//            this.endNode = endNode;
//            this.w = w;
//        }
//
//        @Override
//        public int compareTo(Noode o) {
//            return Long.compare(this.w, o.w);
//        }
//    }
//public class J3124 {
//    static int nodeCnt;
//    static int edgeCnt;
//    static ArrayList<Noode>[] list;
//    static boolean[] visited;
//    static long total;
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(buffer.readLine());
//        int t = 0;
//        while ( T> t) {
//            String[] input = buffer.readLine().split(" ");
//
//            nodeCnt = Integer.parseInt(input[0]);
//            edgeCnt = Integer.parseInt(input[1]);
//
//            visited = new boolean[nodeCnt+1];
//            list = new ArrayList[nodeCnt+1];
//            for (int i = 0; i<= nodeCnt; i++){
//                list[i] = new ArrayList<>();
//            }
//
//            for(int i= 0; i < edgeCnt; i++){
//                input = buffer.readLine().split(" ");
//                int start = Integer.parseInt(input[0]);
//                int end = Integer.parseInt(input[1]);
//                int wight = Integer.parseInt(input[2]);
//                list[start].add(new Noode(end, wight));
//                list[end].add(new Noode(start, wight));
//
//            }
//            total = 0;
//            prime(1);
//            t++;
//            System.out.println("#" + t+ " "+ total);
//
//        }
//
//
//
//    }
//
//    private static void prime(int start) {
//        PriorityQueue<Noode> pq = new PriorityQueue<>();
//        pq.offer(new Noode(start, 0));
//        while(!pq.isEmpty()){
//            Noode dummy = pq.poll();
//            if(!visited[dummy.endNode]){
//                visited[dummy.endNode] = true;
//                total+=dummy.w;
//
//                for(Noode e : list[dummy.endNode]){
//                    if (!visited[e.endNode]){
//                        pq.offer(e);
//                    }
//                }
//
//            }
//
//        }
//
//
//    }
//}
