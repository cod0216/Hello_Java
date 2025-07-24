package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
    디제이맥스 게임 노래 --> 랭킹 리스트 존재
    게임 할 때 마다 얻는 점수가 비 오름 차순으로 저장

    이 랭킹 리스트의 등수는 보통 위에서 몇번째 있는 점수인지로 결정

    하지만 같은 점수 있을 때는 그러한 점수중 가장 작은 등수

    랭킹 리스트에 올라갈 점수의 갯수 P
    리스트에 있는 점수 N개가 비 오름 차순
    태수의 새로운 점수

    만약 점수가 랭킹 리스트에 올라갈 수 없을 정도로 낮다면 -1 출력

    N, 태수, P
 */

/*
    10 1 10
    10 9 8 7 6 5 4 3 2 1
 */
public class J1205 {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N, S, P;
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        P = Integer.parseInt(input[2]);

        Integer[] arr = new Integer[N];
        input = buffer.readLine().split(" ");

        for (int i = 0; i <N; i++) {
           arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr, Collections.reverseOrder());
        if(N==P && S <= arr[N-1]){
            System.out.println(-1);
        }else{
            int rank = 1;
            for (int i = 0; i<N; i++){
                if(S < arr[i]) rank++;
                else break;
            }
            System.out.println(rank);
        }
    }
}
