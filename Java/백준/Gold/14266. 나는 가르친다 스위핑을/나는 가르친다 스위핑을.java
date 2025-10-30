import java.util.*;
import java.io.*;

class Info implements Comparable<Info> {
    float e;
    int v;
    
    public Info(float e, int v){
        this.e = e;
        this.v = v;
    }
    
    public int compareTo(Info o){
        if(o.e == this.e) return  o.v - this.v ;
        return Float.compare(this.e, o.e);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(buffer.readLine());
        
        PriorityQueue<Info> queue = new PriorityQueue<>();

        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);
            
            float res1 = getLine(x1,y1);
            float res2 = getLine(x2,y2);
            
            float max = Math.max(res1, res2);
            float min = Math.min(res1, res2);
            
            queue.offer(new Info(max, -1));
            queue.offer(new Info(min, 1));
        }
        
        int max = 0;
        int cnt = 0;
        
        while(!queue.isEmpty()){
            cnt += queue.poll().v;
            
            max = Math.max(cnt,max);
        }
        
        System.out.println(max);
    }
    
    public static float getLine(int x, int y){
        return (float)y/x;
    }
}
