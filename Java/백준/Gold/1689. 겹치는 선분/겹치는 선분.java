import java.util.*;
import java.io.*;
class Info implements Comparable<Info>{
    int x;
    int v;
    
    public Info(int x, int v){
        this.x = x;
        this.v = v;
    }
    
    public int compareTo(Info o){
        if(this.x == o.x) return this.v - o.v;
        return this.x - o.x;
    }
}


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(buffer.readLine());        

        PriorityQueue<Info> queue = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            queue.offer(new Info(s, 1));
            queue.offer(new Info(e, -1));
        }
        
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            Info cur = queue.poll();            
            cnt += cur.v;
            
            max = Math.max(max,cnt);
        }
        System.out.println(max);

    }
}
