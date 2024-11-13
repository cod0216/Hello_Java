package TIL;

import java.io.*;
import java.util.*;

class Node1774_1 implements Comparable<Node1774_1> {
    public int start;
    public int end;
    public double wight;

    public Node1774_1(int start, int end, double wight) {
        this.start = start;
        this.end = end;
        this.wight = wight;
    }

    @Override
    public int compareTo(Node1774_1 o) {
        double ans = this.wight - o.wight;
        if(ans<0) return -1;
        else if(ans ==0) return 0;
        return 1;
    }
}

public class J1774_1 {
    static int n, m, arr[], dirX[], dirY[];
    static LinkedList<Node1774_1> list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n+1];
        list = new LinkedList<>();
        dirX = new int[n+1];
        dirY = new int[n+1];

        for(int i = 0; i <= n; i++){
            arr[i]  = i;
        } // arr input end

        for(int i = 0; i< n; i++){
            input = buffer.readLine().split(" ");

            dirX[i+1] = Integer.parseInt(input[0]);
            dirY[i+1] = Integer.parseInt(input[1]);

        } // dir input end

        for(int i = 0 ; i< m; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            if(find(a) != find(b)){
                union(a,b);
            }
        } // m input end

        calWight();
        Collections.sort(list);

        double ans = 0;
        for(Node1774_1 node : list){
            if(find(node.start) != find(node.end)){
                union(node.start, node.end);
                ans += node.wight;
            }

        }
        System.out.printf("%.2f\n", ans);
    }


    public static void calWight(){
        for(int i = 1; i<= n; i++){
            for(int j = i+1; j<= n; j++){
                double weight = Math.sqrt(Math.pow(dirX[i]-dirX[j],2) + Math.pow(dirY[i]-dirY[j],2));
                list.add(new Node1774_1(i, j, weight));
                list.add(new Node1774_1(j, i, weight));
            }
        }
    }
    public static int find(int a){
        if(a == arr[a]) return a;
        return arr[a] = find(arr[a]);
    }

    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));

        arr[max] = find(min);
    }
}
