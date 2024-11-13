package TIL;


import java.io.*;
import java.util.*;

class Node21924 implements Comparable<Node21924> {
    public int start;
    public int end;
    public long wight;

    public Node21924(int start, int end, long wight) {
        this.start = start;
        this.end = end;
        this.wight = wight;
    }

    public int compareTo(Node21924 o){
        long ans = this.wight - o.wight;
        if(ans <0) return -1;
        else if(ans == 0) return 0;
        else return 1;
    }
}
public class J21924 {

    static int n, m, arr[];
    static LinkedList<Node21924> list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new LinkedList<>();
        arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i]=i;
        }// arr input end

        for(int i = 0 ; i < m; i++) {
            input = buffer.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            long wight = Long.parseLong(input[2]);
            list.add(new Node21924(start, end, wight));
        }// list input end

        Collections.sort(list);

        long total = 0;
        int cnt =0;
        long ans = 0;

        boolean isCycle = false;

        for(Node21924 node : list){
            total += node.wight;
            if(find(node.start) != find(node.end)){
                union(node.start, node.end);
                ans += node.wight;
                cnt++;
            }
            if(cnt == n-1) isCycle = true;
        }

        System.out.println(isCycle ? total-ans : -1);
    }

    public static int find(int a){
        if(arr[a] == a) return a;
        return arr[a] = find(arr[a]);
    }

    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));

        arr[max] = min;
    }
}
