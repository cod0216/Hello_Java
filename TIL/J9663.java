package TIL;

import java.util.*;
import java.io.*;
class Inf implements Comparable<Inf> {
    int u;
    int d;
    int t;

    public Inf(int u, int d, int t){
        this.u = u;
        this.d = d;
        this.t = t;
    }

    public int compareTo(Inf o){
        return this.t - o.t;
    }
}
public class J9663 {
    static PriorityQueue<Inf>[] queue;
    static int N, E, time[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        queue = new PriorityQueue[N+1];

        for(int i = 0; i <= N; i++){
            queue[i] =  new PriorityQueue<>();
        }

        input = buffer.readLine().split(" ");
        time = new int[N];

        for(int i = 0 ; i < N; i++){
            time[i] = Integer.parseInt(input[i]);
        }


        for(int i = 0 ; i < E; i++){
            input = buffer.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            int t = Integer.parseInt(input[2]);

            queue[u].offer(new Inf(u, d, t));
        }

        int station = 0;
        int operation = 0;
        int n = 0;
        while(E > n){
            operation += time[station];
            Inf person = queue[station].poll();
            if(person.t > operation){
                queue[station].offer(person);
                station = (station+1) % N;
                continue;
            }
            station = (station+1) % N;
            n++;
        }

        System.out.println(operation);
    }
}
