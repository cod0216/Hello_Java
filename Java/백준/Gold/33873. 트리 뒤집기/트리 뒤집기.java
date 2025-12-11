import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] F = new int[N], B = new int[N];
        
        String[] s = br.readLine().split(" ");
        for(int i=0;i<N;i++) F[i] = Integer.parseInt(s[i]);
        
        s = br.readLine().split(" ");
        for(int i=0;i<N;i++) B[i] = Integer.parseInt(s[i]);

        List<Integer>[] g = new ArrayList[N];
        for(int i=0;i<N;i++) g[i] = new ArrayList<>();
        for(int i=0;i<N-1;i++){
            s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0])-1;
            int b = Integer.parseInt(s[1])-1;
            g[a].add(b); g[b].add(a);
        }
        
        long total = 0;
        for(int i=0;i<N;i++) total += Math.max(F[i], B[i]);

        int[] parent = new int[N];
        Arrays.fill(parent, -1);
        
        int[] order = new int[N];
        int p = 0, q = 0;
        
        order[q++] = 0; parent[0] = 0;

        while(p < q){
            int v = order[p++];
            for(int nx : g[v]) if(parent[nx] == -1){
                parent[nx] = v;
                order[q++] = nx;
            }
        }

        int[][] dp = new int[N][2];
        for(int i=0;i<N;i++) dp[i][0]=dp[i][1]=INF;

        for(int i=N-1;i>=0;i--){
            int v = order[i];
            for(int s0=0;s0<2;s0++){
                boolean allow = 
                    (F[v]>B[v] ? s0==0 :
                    (F[v]<B[v] ? s0==1 : true));
                if(!allow) continue;

                int cost = 0;
                for(int nx : g[v]){
                    if(nx == parent[v]) continue;
                    int best = INF;
                    for(int s1=0;s1<2;s1++){
                        if(dp[nx][s1] == INF) continue;
                        best = Math.min(best, dp[nx][s1] + (s1!=s0?1:0));
                    }
                    cost += best;
                }
                dp[v][s0] = cost;
            }
        }

        long ans = Math.min(dp[0][0], dp[0][1] + 1L);
        System.out.println(total + " " + ans);
    }
}
