import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] input1 = buffer.readLine().split(" ");
        String[] input2 = buffer.readLine().split(" ");
        PriorityQueue<int[]> queue = new PriorityQueue<>( (a,b) -> a[1]-b[1]);
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            int a  = Integer.parseInt(input1[i]);
            int b  = Integer.parseInt(input2[i]);
            queue.offer(new int[]{a, b});
        }
        int day = 0;
        long ans = 0;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            ans += (day * now[1]) + now[0];
            // System.out.println(now[0] + " " + now[1]);
            day++;
        }
        System.out.println(ans);
    }
}
