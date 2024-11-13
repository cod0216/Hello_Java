import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class J11724_6 {
    static int n, m;
    static LinkedList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        list = new LinkedList[n+1];

        for(int i = 0 ; i <= n; i++){
            list[i] = new LinkedList<>();
        }
        visited = new boolean[n+1];
        for(int i = 0 ; i <  m; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            list[end].add(start);
        }
        int cnt = 0;
        for(int i =1 ; i<= n; i++){

            if(!visited[i]){
                dfs(i);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
    public static void dfs(int a){
//        if(visited[a]) return;
        visited[a] = true;
        for(int next : list[a]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
