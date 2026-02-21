import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        
        Deque<int[]> queue = new ArrayDeque<>();
        int[] arr = new int[N];
        
        String[] input = buffer.readLine().split(" ");
        for(int i = 0 ; i < N ; i++){
            int v = Integer.parseInt(input[i]);
            arr[i] = v;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("1 ");
        
        int pop = arr[0];
        
        for(int i = 1 ; i < N; i++){
            queue.add(new int[] {(i+1), arr[i]});
        }
        
        while(!queue.isEmpty()){
            if(pop > 0){
                for(int i = 1 ; i < pop; i++){
                    queue.offer(queue.poll());
                }
                
                int [] next = queue.poll();
                pop = next[1];
                sb.append(next[0] + " ");
            } else{
                for(int i = 1 ; i < Math.abs(pop); i++){
                    queue.addFirst(queue.pollLast());
                }
                
                int [] next = queue.pollLast();
                pop = next[1];
                sb.append(next[0] + " ");
            }   
        }
        
        System.out.println(sb.toString());
    }
}
