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
        if(this.s == o.s) return this.e - o.e;
        return o.s - this.s;
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
            if(e < s) queue.offer(new Info(s, e));
            
        }
        
        int start = 0;
        int end = 0;
        long diff = 0;
        long sum = 0;
        
        if(queue.isEmpty()){
            System.out.println(M);
            return;
        }else {
            Info cur = queue.peek();
            start = cur.e;
            end = cur.s;
            
            diff = Math.abs(start-end);
        }

        while(!queue.isEmpty()){
            Info cur = queue.poll();
            int e = cur.e;
            int s = cur.s;
            if(start <= s && e < start){
                start = e;
            } else if(s < start){
                diff = Math.abs(start-end);
                sum += diff;
                end = s;
                start = e;
            }
        }

        diff = Math.abs(start-end);
        sum += diff;
        
        sum = sum * 2;
        long ans = sum + M;
        
        System.out.println(ans);
    }
}
