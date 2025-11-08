import java.util.*;
import java.io.*;

class Info implements Comparable<Info> {
    int e;
    int w;
    
    public Info(int e, int w){
        this.e = e;
        this.w = w;
    }
    
    public int compareTo(Info o){
        return this.w - o.w;
    }
}

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        while(T-->0){
             N = Integer.parseInt(buffer.readLine());
            String[] input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            ArrayList<int[]> flist = new ArrayList<>();
            flist.add(new int[]{start, end});
            
            for(int i = 0; i < N; i++){
                input = buffer.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);                
                flist.add(new int[]{x,y});
            }

            input = buffer.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);                            
            flist.add(new int[]{x,y});
            
            LinkedList<int[]>[] list = new LinkedList[flist.size()];
            for(int i = 0 ; i < flist.size(); i++){
                list[i] = new LinkedList<>();
            }
            
            for(int i = 0 ; i < flist.size()-1; i++){
                int[] cur = flist.get(i);
                for(int j = i+1 ; j < flist.size(); j++){                
                    int[] now = flist.get(j);                    
                    int w = getDis(cur[0], now[0], cur[1], now[1]);
                    // System.out.println(i + "->" + j + " : " + w);
                    list[i].add(new int[]{j, w});
                    list[j].add(new int[]{i, w});
                }
            }
            
            PriorityQueue<Info> queue = new PriorityQueue<>();
            int[] dist = new int[flist.size()+1];
            boolean[] visited = new boolean[flist.size()+1];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[0] = 0;
            queue.offer(new Info(0, 0));
            boolean flag = false;
            while(!queue.isEmpty()){
                Info cur = queue.poll();
                if(dist[cur.e] == Integer.MAX_VALUE) continue;
                visited[cur.e] = true;
                
                if(cur.w > 1000){
                    flag = true;
                }
                
                for(int[] s : list[cur.e]){
                    if(!visited[s[0]] && 1000 >= s[1]){
                        dist[s[0]] = s[1];
                        // System.out.println(cur.e + " -> "+ s[0] + " : " + dist[s[0]]);
                        queue.offer(new Info(s[0], dist[s[0]]));
                    }
                }
            }
            if(dist[flist.size()-1] == Integer.MAX_VALUE) System.out.println("sad");
            else System.out.println("happy");
        }
    }
    public static int getDis(int x1, int x2, int y1, int y2){
        return (Math.abs(x1 - x2)+Math.abs(y1 - y2));
    }
}
