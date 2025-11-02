import java.util.*;
import java.io.*;

class Info implements Comparable<Info>{
    int start;
    int end;
    int n;
    
    public Info(int start, int end, int n){
        this.start = start;
        this.end = end;
        this.n = n;
    }
    public int compareTo(Info o){
        if(this.start == o.start) return o.end - this.end;
        return this.start - o.start;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] yes = new int[N+1];
        PriorityQueue<Info> queue = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int n = i+1;
            
            queue.offer(new Info(s,e,n));
        }
        
        Info cur = queue.poll();
        int start = cur.start;
        int end = cur.end;
        int n = cur.n;
        yes[n] = n;
        
        while(!queue.isEmpty()){
            Info now = queue.poll();
            int s = now.start;
            int e = now.end;
            
            
            if(s <= end){
                yes[now.n] = n;
                if(e > end) end = e;
            }else {
                start = s;
                end = e;
                n = now.n;
                yes[n] = n;
            }
        }
        for(int i = 0 ; i < M; i++){
            input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            System.out.println((yes[s] == yes[e] ? "1" : "0"));
            
        }
        
    }
}
