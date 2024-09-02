

import java.io.*;
import java.util.*;


class Edge implements Comparable<Edge>{
    public int end;
    public double wight;

    public Edge(int end, double wight) {
        this.end = end;
        this.wight = wight;
    }

    @Override
    public int compareTo(Edge o) {
        if(this.wight < o.wight)
            return -1;
        else if (this.wight == o.wight) return 0;
        else return 1;
    }
}// 시작 섬, 끝 섬, 길이 저장용 클래스



public class S1250 {
    static double E; // 환경 부담금
    static long[] arrX; // x좌표 저장
    static long[] arrY; // y좌표 저장
    static boolean[] visited; // 유니온용 배열
    static long dis;
    static ArrayList<Edge>[] list;
    static int n;
    static double w;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t) {

            n = Integer.parseInt(buffer.readLine());


            arrX = new long[n];
            arrY = new long[n];

            String[] input = buffer.readLine().split(" ");
            for(int i = 0; i <n; i++){
                arrX[i] = Long.parseLong(input[i]);
            }

            input = buffer.readLine().split(" ");
            for(int i = 0; i <n; i++){
                arrY[i] = Long.parseLong(input[i]);
            }

            E = Double.parseDouble(buffer.readLine());
            list = new ArrayList[n];


            setList();

            //입력 -완-

            visited = new boolean[n];
            prim(1);


            t++;
            System.out.println("#" + t + " " + Math.round(w*E));
        }

    }

    private static void setList() {
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i <n; i++ ){
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                long dis = (arrX[i]-arrX[j])*(arrX[i]-arrX[j]) + (arrY[i]-arrY[j]) * (arrY[i]-arrY[j]);
                list[i].add(new Edge(j,dis));
//                list[j].add(new Edge(i,dis));
            }
        }
    }

    private static void prim(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));
        w = 0;

        while(!pq.isEmpty()){

            Edge dummy= pq.poll();
            if(!visited[dummy.end]) {
                visited[dummy.end] = true;
                w += dummy.wight;


                for (Edge edge : list[dummy.end]) {
                    if (!visited[edge.end]) {
                        pq.offer(edge);
                    }
                }
            }
        }

    }

}
