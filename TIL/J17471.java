package TIL;

import java.io.*;
import java.util.*;

public class J17471 {
    static int N;
    static ArrayList<Integer>[] cities;
    static int[] people;
    static boolean[] color; //두개의 색으로 분류 하는 배열
    static boolean[] visited;
    static int truePeople;
    static int falsePeople;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(buffer.readLine());

        String[] input = buffer.readLine().split(" ");

        cities = new ArrayList[N+1];
        people = new int[N+1];


        for(int i = 0; i < N+1; i++) {
            cities[i] = new ArrayList<>();
        }


        for(int i = 0; i < N; i++) {
            people[i+1] = (Integer.parseInt(input[i]));
        } // 초기화 밑 도시 정도 저장


        for(int i = 0; i < N; i++){ // 도시 연결 완료
            input = buffer.readLine().split(" ");
            int k = Integer.parseInt(input[0]);
            for(int j = 0 ; j < k; j++) {
                cities[i].add(Integer.parseInt(input[j+1]));
            }
        }

        min = Integer.MAX_VALUE;
        visited = new boolean[N+1];
        color = new boolean[N+1];
//        truePeople = 0;
//        falsePeople = 0;

        selectColor(0,0); // 색 지정  -> 부분집합

        if(min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);

    }

    /*
    부분집합으로 풀고 ( 섹 정)
    연결된 곳 벨리데이션하고
    참이면 갯수
     */

    public static void cal(){
        int res = Math.abs(truePeople - falsePeople);
        min = Math.min(min, res);
    }

    public static void temp(int start, int cnt, int n){
        if(n >= cnt){
            countPeople();
            cal();
            return;
        }

        for(int node : cities[start]){
            if(color[node] && !visited[node]){
                visited[node] = true;
                temp(node, cnt, n+1);
            }
        }
    }

    /**
     *
     * @param cnt 인덱스 번호
     * @param n 부분집합 된 개수
     */
    private static void selectColor(int cnt, int n) {
        if(cnt >= N+1){
            visited = new boolean[N+1];
            for(int i = 1 ; i<N; i++){
                if(color[i]) {
                    temp(i,n,0);
                    break;
                }
            }
            return;
        }

        color[cnt] = true;
        selectColor(cnt+1, n+1);
        color[cnt] = false;
        selectColor(cnt+1, n);
    }


    public static void countPeople(){

        truePeople = 0;
        falsePeople = 0;
        for(int j = 1; j <= N; j++){
            if(color[j]) truePeople += people[j];
            else falsePeople+=people[j];
        }
    }
}
