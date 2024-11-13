import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class J1766 {

    static int n, m, countArr[];
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
         String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        list = new ArrayList[n+1];
        countArr = new int[n+1];

        for(int i = 0; i <=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i< m; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            countArr[end]++;
        }

        polo();
     }

     public static void polo(){
         PriorityQueue<Integer> pq = new PriorityQueue<>();
         for(int i = 1; i <= n; i++){
             if(countArr[i] ==0){
                 pq.offer(i);
             }
         }

         while(!pq.isEmpty()){
             int cur = pq.poll();
             System.out.print(cur+ " ");

             for(int now : list[cur]){
                 countArr[now]--;
                 if(countArr[now] ==0){
                     pq.offer(now);
                 }
             }
         }
     }

}
