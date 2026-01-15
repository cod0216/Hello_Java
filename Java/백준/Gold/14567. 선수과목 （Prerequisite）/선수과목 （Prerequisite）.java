

import java.io.*;
import java.util.*;

public class Main {
    static int n, m, countArr[], arr[];
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        list = new ArrayList[n+1];
        countArr = new int[n+1];
        arr = new int[n+1];

        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();


        for(int i = 0 ; i < m; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            countArr[end]++;
        }

        polo();

        for(int i = 1; i <= n; i++){
            System.out.print(arr[i]+" ");
        }

    }
    public static void polo(){
        int cnt = 1;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            if(countArr[i] == 0){
                queue.offer(i);
                arr[i] = cnt;
            }

        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int now : list[cur]){

                countArr[now]--;
                if(countArr[now] == 0){
                    queue.offer(now);
                    arr[now] = arr[cur]+1;
                }
            }
        }
    }
}
