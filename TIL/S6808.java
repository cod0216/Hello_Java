package TIL;


import java.util.*;
import java.io.*;

public class S6808 {
    static int[] cardA; // 규영이
    static int[] cardB; // 영
    static boolean[] visited;

    static int win;
    static int lose;

    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T >t){
            String[] input = buffer.readLine().split(" ");

            cardA = new int[9];
            boolean[] checkNum = new boolean[19];

            for(int i = 0 ; i < 9; i++) {
                cardA[i] = Integer.parseInt(input[i]); // 규영
                checkNum[Integer.parseInt(input[i])] = true;

            }

            cardB = new int[9];
            visited = new boolean[9];
            int index = 0;

            for(int i = 1 ; i < 19; i++){
                if(!checkNum[i]){
                    cardB[index++] = i;
                }
                if(index >=9) break;
            }


            win = 0;
            lose = 0;

            int[] temp = new int[9];
            Permutation(0, temp);


            t++;
            System.out.println("#" + t + " "+ win + " " + lose);
        }

    }

    public static void Permutation(int cnt, int[] arr) {
        if(cnt >= 9){
            int scoreA = 0;
            int scoreB = 0;

            for(int i = 0 ; i < 9 ; i++){
                if(arr[i]>cardA[i]) scoreB += (arr[i] + cardA[i]);
                else if(cardA[i]>arr[i]) scoreA += (cardA[i] + arr[i]);
            }

            if(scoreB > scoreA) lose+=1;
            else if(scoreA > scoreB) win+=1;
            return;
        }

        for(int i = 0; i <9; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = cardB[i];

                Permutation(cnt+1, arr);
                visited[i] = false;
            }
        }
    }
}
