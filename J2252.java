import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class J2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        LinkedList<Integer> list[] = new LinkedList[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

        int d[] = new int[N+1];


        for (int i = 0; i < M; i++) {
            input = buffer.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            d[end]++;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <=N ; i++) {
            if(d[i] == 0) queue.offer(i);
        }

        int key = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                key = queue.poll();
                for(int k : list[key]){
                    d[k]--;
                    if(d[k] == 0) queue.offer(k);
                }

                System.out.print(key + " ");
            }
        }
    }
}