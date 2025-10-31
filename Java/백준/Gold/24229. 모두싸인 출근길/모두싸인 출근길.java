import java.util.*;
import java.io.*;

class Info implements Comparable<Info>{
    int s;
    int e;
    
    public Info(int s, int e){
        this.s = s;
        this.e = e;
    }
    
    public int compareTo(Info o){
        if(this.s == o.s) return o.e - this.e;
        return this.s - o.s;
    }
    
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        
        PriorityQueue<Info> queue = new PriorityQueue<>();
            
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            
            queue.offer(new Info(s,e));
        }

        ArrayList<Info> list = new ArrayList<>();
        Info cur = queue.poll();
        int s = cur.s;
        int e = cur.e;
        
        while(!queue.isEmpty()){
            
            Info next = queue.poll();
            if(next.s <= e){
                e = Math.max(next.e ,e);
            } else {
                list.add(new Info(s,e));
                s = next.s; e = next.e;
            }
        }
        list.add(new Info(s,e));
        
        
        int start = list.get(0).s;
        int end = list.get(0).e;
        long diff = Math.abs(start-end);
        long ans = end;
        int i = 0;
        while (true) {
            long reach = end + diff;
            int j = i + 1;
            if (j >= list.size() || list.get(j).s > reach) break;

            int bestIdx = -1;
            long bestScore = Long.MIN_VALUE;
            int k = j;
            while (k < list.size() && list.get(k).s <= reach) {
                int ns = list.get(k).s;
                int ne = list.get(k).e;
                long score = 2L * ne - ns;
                if (score > bestScore) {
                    bestScore = score;
                    bestIdx = k;
                }
                k++;
            }

            int ns = list.get(bestIdx).s;
            int ne = list.get(bestIdx).e;
            ans = ne;
            start = ns;
            end   = ne;
            diff  = Math.abs(ne - ns);
            i = bestIdx;
        }      
        
        System.out.println(ans);
    }
}
