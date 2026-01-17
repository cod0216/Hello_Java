import java.util.*;
import java.io.*;

public class Main {
    static int N, M, idx, arr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        idx = 0;
        int[] temp = new int[N];
        boolean[] used = new boolean[10001];
        
        input = buffer.readLine().split(" ");
        for(int i = 0 ; i< N; i++) {
            int v = Integer.parseInt(input[i]);
            if(used[v]) continue;
            used[v] = true;
            temp[idx++] = v;
        }
        arr = new int[idx];
        for(int i = 0 ; i < idx; i++) arr[i] = temp[i];
        Arrays.sort(arr);
    
        dfs(0, new int[M]);
        System.out.print(sb.toString());
    }
    public static void dfs(int now, int[] num){
        if(now == M){
            for(int i = 0 ; i < now; i++){
                sb.append(num[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        

        // System.out.println("내부: " + arr[s]);
        for(int i = 0 ; i <idx; i++ ){
            num[now] = arr[i];
            dfs(now+1, num);

        }
    }
}
