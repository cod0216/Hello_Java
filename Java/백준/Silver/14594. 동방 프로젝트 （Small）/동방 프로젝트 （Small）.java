import java.util.*;
import java.io.*;
class Info implements Comparable<Info>{
    int x;
    int y;
    
    public Info(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int compareTo(Info o){
        if(this.x == o.x) return o.y - this.y;
        return this.x - o.x;
    }
    
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int B = Integer.parseInt(buffer.readLine());
        
        PriorityQueue<Info> queue = new PriorityQueue<>();
        
        for(int i = 0 ; i < B; i++){
            String[] input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            
            queue.offer(new Info(x,y));

        }
        if(B == 0){
            System.out.println(N); 
            return;  
        } 
        Info cur = queue.poll();        
        int start = cur.x;
        int end = cur.y;
        int cnt = Math.abs(start-end) + 1;
        
        while(!queue.isEmpty()){
            cur = queue.poll();                    
            int s = cur.x;
            int e = cur.y;        
            
            if(end >= s){
                if(end < e){
                  cnt = cnt + Math.abs(e - end); 
                  end = e;  
                } 
            } else {
                end = e;
                start = s;
                cnt += Math.abs(start-end);
            }            
        }
        System.out.println(N-cnt+1);
    }
}
