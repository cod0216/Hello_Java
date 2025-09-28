package TIL;

import java.io.*;
import java.util.*;

public class J9466 {
    static int arr[], ans;
    static boolean[] finish, visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){
            int n = Integer.parseInt(buffer.readLine());
            arr = new int[n+1];
            ans = 0;
            visited = new boolean[n+1];
            finish = new boolean[n+1];
            String[] input = buffer.readLine().split(" ");
            for(int i = 0 ; i < n; i++){
                arr[i+1]= Integer.parseInt(input[i]);
            }
            for(int i = 1 ; i <= n; i++){
                if(visited[i])continue;
                dfs(i);
            }

            System.out.println(n-ans);
            t++;
        }
    }

    public static void dfs(int start){
        visited[start] = true;
        int next = arr[start];

        if(!visited[next]){
            dfs(next);
        }else if(!finish[next]){
            int l = 1;
            while(next != start){
                l++;
                next = arr[next];
            }
            ans += l;
        }

        finish[start] = true;
    }
}
