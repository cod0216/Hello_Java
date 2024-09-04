package TIL;

import java.util.*;
import java.io.*;


/*
 * 외판원 순회는 TSP라고 불리는 문제이다. 여러가지 변종 문제도 있으니 참고
 * 1번 부터 N번까지 전호가 매겨져 있는 도시들이 있고, 도시들 사이에는 길이 있다. (없을 수도 있음)
 *
 * 한 도시에서 출발해 N개의 도시를 모두 거쳐 다시 원래의 도시로 돌아오는 순회 여행 경로를 계획하려고 한다.
 *
 * 단 한 번 갔던 도시로는 다시 갈 수 없다.(마지막 도착지가 출발지인 경우만 제외) 이런 여행 경로는 여러가지가 있지만
 * 각장 적은 비용을 들이는 여행 계획으 세우고자 한다.
 *
 * map[i][j] -> i 도시에서 j 도시로 이동하는 비용
 * map[j][i] -> i 도시에서 j 도시로 이동하는 비용
 *
 * 모든 노드를 연결 시키기
 *
 */

public class J10971 {
    static int n;
    static int[][] map;
    static ArrayList<int []>[] list;
    static int[] dist;


    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());
        map = new int[n][n];
        list = new ArrayList[n];
        dist = new int[n];


        for(int i = 0 ; i < n; i++) {
            String[] input = buffer.readLine().split(" ");
            list[i] = new ArrayList<>();
            dist[i] =Integer.MAX_VALUE;

            for(int j = 0; j< n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j< n; j++) {
                list[i].add(new int[] {j, map[i][j]});

            }
        }
        /*
         * ========================================입력 완
         */








        for(int i = 0; i< n; i++) {

        }


    }

}
