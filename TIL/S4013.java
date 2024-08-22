package TIL;

import java.io.*;
import java.util.*;


public class S4013 {
    static LinkedList<Integer>[] m;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

       int T = Integer.parseInt(buffer.readLine());
       int t = 0;
       while(T > t){
            m = new LinkedList[4];


           String[] input;
           int n = Integer.parseInt(buffer.readLine());

           for(int i = 0 ; i <4 ; i ++) {
               m[i] = new LinkedList<>();
                   input = buffer.readLine().split(" ");
                   for (int j = 0; j < 8; j++) {
                       m[i].offer(Integer.parseInt(input[j]));
                   }
           }

           for(int i = 0; i < n; i++){
               visited = new boolean[4];
               input = buffer.readLine().split(" ");
                // start: 시작
                // torque : 방향
               int start= (Integer.parseInt(input[0])-1);
               int torque= Integer.parseInt(input[1]);

               work(start, torque);
           }

           result = 0;

           for(int i = 0; i< 4; i++){
               if(m[i].getFirst() == 1){
                   result += Math.pow(2,i);
               }
           }
           t++;
           System.out.println("#"+ t + " " + result );
       }
    }

    //DFS : 극이 같으면 작업 안함 극이 다르면 작업 진행
    public static void work(int start, int torque){
        visited[start] = true;
        int left = start - 1;
        int right = start + 1;
        // 톱니는 4개 뿐이니까 음수 나오면 무시 5 넘어도 마찬가지
        //좌우 확인 따로 하기
        if(left >= 0 && !visited[left]){
            if (m[start].get(6) != m[left].get(2)){ // 극 다르면 작업 준비
                work(left, -torque);
            }
        }

        if(right < 4 && !visited[right]){
            if (m[start].get(2) != m[right].get(6)){
                work(right, -torque); // 극 다르면 작업 준비
            }
        }

        if(torque == 1){ // 이경영
            int value = m[start].pollLast();
            m[start].offerFirst(value);
        } else{
            int value = m[start].pollFirst();
            m[start].offerLast(value);
        }
    }
}
