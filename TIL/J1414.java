package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class J1414 {
    static int parents[], map[][], n,res,ans;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        map = new int[n][n];
        String input[];
        parents = new int[n+1];
        for(int i = 0; i <= n; i++){
            parents[i] = i;
        }

        for(int i = 0; i < n; i++){
            input= buffer.readLine().split("");
            for(int j = 0; j < n; j++){
                int c = input[j].charAt(0);
                if(c == 48) map[i][j] = Integer.MAX_VALUE;
                else {
                    if(c>=97) c -=96;
                    else c -=38 ;
                    map[i][j] = c;
                    ans+= c;
                }
            }
        } //input end

        mst();
    }

    public static void mst(){
        int cnt=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o->o[2]));
        for(int i = 0; i < n; i++ ){
            for(int j = 0; j < n; j++ ){
                pq.offer(new int[]{i, j, map[i][j]});
            }
        }
        while(!pq.isEmpty()) {
           int[] cur = pq.poll();
           if(find(cur[0]) != find(cur[1])){
               union(find(cur[0]),find(cur[1]));
               res+=cur[2];
               cnt++;
           }
        }// pq while end
        if(ans-res <0){ System.out.println(-1); return;}

        System.out.println(cnt != n-1 ? -1 : ans-res);
    }

    public static int find(int num){
        if(parents[num] == num) return num;
        return parents[num] = find(parents[num]);
    }

    public static void union(int a, int b){
        int max = Math.max(a,b);
        int min = Math.min(a,b);

        parents[max] = min;
    }
}
