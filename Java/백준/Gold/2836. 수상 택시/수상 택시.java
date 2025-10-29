import java.util.*;
import java.io.*;

class Info implements Comparable<Info> {
    int s;
    int e;
    public Info(int s, int e){
        this.s = s;
        this.e = e;        
    }
    
    public int compareTo(Info o){
        if (o.s == this.s) return this.e - o.e;
        return o.s- this.s;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        if(N == 0 ){
            System.out.println(M);
            return;
        }
        
        PriorityQueue<Info> queue = new PriorityQueue<>();
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            if( s > e) queue.offer(new Info(s,e));
            
        }
        

        int start=0;
        int end=0;
        long diff = 0;
        long cnt = 0;
        
        if(!queue.isEmpty()){
            start = queue.peek().e;
            end = queue.peek().s;
            
            queue.poll();
            
            diff = Math.abs(start-end);
            // System.out.println("diff : " + diff);
        }

        while(!queue.isEmpty()){
            Info cur = queue.poll();
            int s = cur.s;
            int e = cur.e;
            
            if(s < start) {
                start = e;
                end = s;
                cnt += diff;
                diff = Math.abs(s-e);
                // System.out.println("인 start : " + start + ", end : " + end + ", s : " + s + ", e : " + e + ", diff : " + diff);
            }
            else if(start <= s && e < start){
                diff += Math.abs(start-e);
                // System.out.println("start : " + start + ", end : " + end + ", s : " + s + ", e : " + e + ", diff : " + diff);
                start = e;
                end = s;

            }
        }

        
        cnt += diff;
        long ans = (cnt*2) + M;
        
        System.out.println(ans);
    }
}
