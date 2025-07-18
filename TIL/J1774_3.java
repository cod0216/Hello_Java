package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

class Graph implements Comparable<Graph> {
    int x;
    int y;
    double w;

    public Graph(int x, int y, double w) {
        this.x = x;
        this.y = y;
        this.w = w;
    }

    public int compareTo(Graph o2){
        return Double.compare(this.w, o2.w);
    }
}

public class J1774_3 {
    static int spaceCount, lineCount;
    static int[] x, y, parent;
    static double ans = 0;
    static LinkedList<Graph> graph;
    static BufferedReader buffer;
    public static void initializeBuffer() {
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void setValues() throws IOException{
        String[] input = buffer.readLine().split(" ");
        spaceCount = Integer.parseInt(input[0]);
        lineCount = Integer.parseInt(input[1]);

        parent = new int[spaceCount+1];
        x = new int[spaceCount+1];
        y = new int[spaceCount+1];

        for (int i = 1; i <=spaceCount; i++) {
            input = buffer.readLine().split(" ");
            x[i]= Integer.parseInt(input[0]);
            y[i]= Integer.parseInt(input[1]);
            parent[i] = i;
        }

        for (int i = 0; i <lineCount; i++) {
            input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            union(x, y);

        }
    }

    public static int find (int num){
        if(parent[num] != num) return parent[num] = find(parent[num]);
        return parent[num];
    }

    public static void union (int a, int b){
        int max = Math.max(find(a),find(b));
        int min = Math.min(find(a),find(b));

        if(max != min) parent[max] = min;
    }

    public static void setGraph(){
        graph = new LinkedList<>();

        for (int i = 1; i <= spaceCount; i++) {
            for (int j = 1; j <= spaceCount; j++) {
                if(j == i) continue;
                double w = Math.sqrt(Math.pow(Math.abs(x[i]-x[j]),2) + Math.pow(Math.abs(y[i]-y[j]),2));
                graph.add(new Graph(i,j,w));
            }
        }
    }

    public static void mst(){
        Collections.sort(graph);

        for (Graph e : graph) {
            if(find(e.x) != find(e.y)){
                ans += e.w;
                union(e.x, e.y);
            }
        }
    }

    public static void print(){
        System.out.printf("%.2f\n", ans);
    }

    public static void main(String[] args) throws IOException {
        initializeBuffer();
        setValues();
        setGraph();
        mst();
        print();
    }
}
