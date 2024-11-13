package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class J2056 {
    static int n, countArr[], timeArr[];
    static LinkedList<Integer>[] list;
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());

        list = new LinkedList[n+1];
        countArr = new int[n+1];
        timeArr = new int[n+1];
        visited = new boolean[n+1];

        for(int i = 0; i <= n; i++){
            list[i] = new LinkedList<>();
        }

        String[] input;
        for(int i = 1 ; i<=n; i++){
            input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            timeArr[i] = node;
            int f = Integer.parseInt(input[1]);
            for(int  j = 2 ; j < 2+f; j++){
                int edge = Integer.parseInt(input[j]);
                list[edge].add(i);
                countArr[i]++;
            }
        }// input end

        polo();

    }

    public static void polo(){
        int res[] = new int[n+1];
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i<=n; i++){
            res[i] = timeArr[i];
            if(countArr[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();
//            if(visited[cur]) continue;
//            visited[cur] = true;

            for(int now : list[cur]){
                countArr[now]--;
                res[now] = Math.max(res[now], res[cur] + timeArr[now]);
                if(countArr[now] == 0){
                    queue.offer(now);
                }
            }
        } // queue while end

//        int min = Integer.MAX_VALUE;
//        for (int i = 1; i <= n; i++) {
//            min = Math.min(res[i], min);
//        }
//        System.out.println(min);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(res[i], max);
        }
        System.out.println(max);




    }
}





