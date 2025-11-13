import java.util.*;
import java.io.*;

public class Main {
    static int N, M, p[], cnt[];
    static HashMap<String, Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());

        while(N --> 0){
            list = new HashMap<>();
            M = Integer.parseInt(buffer.readLine());            
            p = new int[M*2+1];
            cnt = new int[M*2+1];
            for(int i = 0 ; i < (M*2)+1; i++){
                p[i] = i;
                cnt[i]=1;
            }
            int num = 1;
            for(int i = 0 ; i < M; i++){
                String[] input = buffer.readLine().split(" ");
                String s1 = input[0];
                String s2 = input[1];
                if(!list.containsKey(s1)){
                    list.put(s1,num++);
                }
                if(!list.containsKey(s2)){
                    list.put(s2,num++);         
                }
                
                union(p[list.get(s1)], p[list.get(s2)]);
                System.out.println(cnt[find(list.get(s1))]);
                
            }
        }
        
    }
    
    public static void union(int a, int b){
        int r = find(a);
        int m = find(b);
        if(r == m) return;
        
        if(r < m){
            p[m] = r;
            cnt[r] += cnt[m];
        }else {
            p[r] = m;
            cnt[m] += cnt[r];            
        }
    }
    public static int find(int n ){
        if(p[n] != n) return p[n] = find(p[n]);
        return n;
    }
}
