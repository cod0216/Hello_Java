package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class J2644 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        LinkedList<Integer> list[] = new LinkedList[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new LinkedList<>();
        }

       String[] input = buffer.readLine().split(" ");
       int a = Integer.parseInt(input[0]);
       int b = Integer.parseInt(input[1]);

       int M = Integer.parseInt(buffer.readLine());
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < M; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[end].add(start);
            list[start].add(end);
        }

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(a);
        int key = 0;
        int size = 0;
        int count = 0;
        int ans = -1;
        while(!queue.isEmpty()){
            size = queue.size();
            for(int i = 0 ; i< size; i++){
                key = queue.poll();
                if(key == b){
                    ans = count;
                    break;
                }
                for(int l : list[key]){
                    if(visited[l]) continue;
                    visited[l] = true;
                    queue.offer(l);
                }
            }
            count++;
        }
        System.out.println(ans);
    }
}
