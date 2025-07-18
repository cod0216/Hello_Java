package TIL;

import java.io.*;
import java.util.*;


class P2887 {
    public int order;
    public int x;
    public int y;
    public int z;

    public P2887(int o, int x, int y, int z) {
        this.order = o;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public P2887(P2887 point){
        this.order = point.order;
        this.x = point.x;
        this.y = point.y;
        this.z = point.z;
    }

}

class Graph_0 {
    public int start;
    public int end;
    public int w;

    public Graph_0(int start, int end, int w){
        this.start = start;
        this.end = end;
        this.w = w;
    }

}
public class J2887 {
    static int parents[];

    public static int find(int n){
        if(parents[n] != n) return parents[n] = find(parents[n]);
        return parents[n];
    }

    public static void union(int a, int b){
       int max = Math.max(find(a), find(b));
       int min = Math.min(find(a), find(b));

       if(max != min) parents[max] = min;
    }

    public static int getDir(int a, int b){
        int w = Math.abs(a - b);
        return w;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        ArrayList<P2887> point[] = new ArrayList[N];
        PriorityQueue<Graph_0> queue = new PriorityQueue<>((a, b) -> a.w - b.w);

        String[] input;
        parents = new int[N+1];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
            point[i] = new ArrayList<>();

            input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int z = Integer.parseInt(input[2]);

            point[i].add(new P2887(i,x,y,z));
        }
        Arrays.sort(point, (a, b) -> a.get(0).x - b.get(0).x);
        for (int i = 0; i < N-1; i++) {
            int w = getDir(point[i].get(0).x, point[i+1].get(0).x);
            queue.offer(new Graph_0(point[i].get(0).order, point[i+1].get(0).order, w));
        }

        Arrays.sort(point,(a ,b) -> a.get(0).y-b.get(0).y);
        for (int i = 0; i < N-1; i++) {
            int w = getDir(point[i].get(0).y, point[i+1].get(0).y);
            queue.offer(new Graph_0(point[i].get(0).order, point[i+1].get(0).order, w));
        }

        Arrays.sort(point,(a ,b) -> a.get(0).z-b.get(0).z);
        for (int i = 0; i < N-1; i++) {
            int w = getDir(point[i].get(0).z, point[i+1].get(0).z);
            queue.offer(new Graph_0(point[i].get(0).order, point[i+1].get(0).order, w));
        }

        int ans = 0;
        while(!queue.isEmpty()){
            Graph_0 e = queue.poll();
            if(find(e.start) != find(e.end)){
                ans += e.w;
                union(e.start, e.end);
            }
        }
        System.out.println(ans);
    }

}
