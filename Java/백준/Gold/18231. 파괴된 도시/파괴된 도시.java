import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        list = new LinkedList[N+1];
        int[] state = new int[N+1];
        for(int i = 0; i <= N; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            list[a].add(b);
            list[b].add(a);
        }
        
        int B = Integer.parseInt(buffer.readLine());
        int[] boom = new int[B];
        
        input = buffer.readLine().split(" ");
        for(int i = 0; i < B; i++){
            boom[i] = Integer.parseInt(input[i]);
            state[boom[i]] = 1;
        }

        int[] isBomb = new int[N + 1];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for (int i = 0; i < B; i++) {
            int node = boom[i];
            boolean possible = true;

            for (int now : list[node]) {
                if (state[now] == 0) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                isBomb[node] = 1;
                ans.add(node);
            }
        }
        
        int[] temp = new int[N + 1];

        for (int node : ans) {
            temp[node] = 1;
            for (int now : list[node]) {
                temp[now] = 1;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (state[i] != temp[i]) {
                System.out.println(-1);
                return;
            }
        }

        Collections.sort(ans);

        StringBuilder sb = new StringBuilder();
        sb.append(ans.size()).append("\n");
        
        for (int x : ans){
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());
    }
       
}
    

