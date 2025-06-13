package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Info{
    int rank;
    int start;
    int end;

    public Info(int rank, int start, int end) {
        this.rank = rank;
        this.start = start;
        this.end = end;
    }
}
public class J24042 {
    static int n, p, dist[], d=1;
    static boolean visited[];

    static LinkedList<Info>[] list;
    static LinkedList<Info> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]); // node
        p = Integer.parseInt(input[1]); // iter

        int c = 1; // count handle
        list = new LinkedList[n + 1];
        dist = new int[n + 1]; // distance
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            list[i] = new LinkedList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;

        debug();

        while (true) {
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            list[c].add(new Info(c, s, e));
            list[c].add(new Info(c, e, s));

            if (s == 1) queue.add(new Info(c, s, e));
            if (e == 1) queue.add(new Info(c, e, s));

            if (c >= p) break;
            c++;
        } // input end

        System.out.println(find());
        for (int i = 0; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
    }

    public static int find(){
        while(!queue.isEmpty()){
            Info cur = queue.poll();

            if(cur.start == n) break;

            for(Info now : list[cur.end]){
                if(cur.rank < now.rank && !visited[now.start]){
                    if( dist[now.start] > dist[cur.start] + now.rank){
                        dist[now.start] = dist[cur.start] + now.rank;
                        queue.add(now);
                        visited[cur.start] = true;
                    }
                }
            }
        } // queue while end

        return dist[n];// ans
    }

    static public void debug(){
        System.out.println("debug : ["+d+"]");
        d++;
    }
}


