package TIL;

import java.io.*;
import java.util.*;

public class J17471 {
    static int N,min;
    static boolean[] redPeople, bluePeople,visited;
    static int[] people;;

    static ArrayList<Integer>[] cities;
    public static void main (String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        min = Integer.MAX_VALUE;
        N = Integer.parseInt(buffer.readLine());
        cities = new ArrayList[N+1];
        people = new int[N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i <= N; i++){
            cities[i] = new ArrayList<>();
        }

        String[] input = buffer.readLine().split(" ");


        for(int i =0; i< N; i++){
            people[i+1] = Integer.parseInt(input[i]);
        }

        for(int i = 1; i <= N; i++){
            input = buffer.readLine().split(" ");
            int index = Integer.parseInt(input[0]);

            for(int j = 1; j<= index; j++){ //수정 완료
                int node = Integer.parseInt(input[j]);
                cities[i].add(node);
            }
        }

        // ======== 입력 완료 ==========

        powerSet(N, 0, new boolean[N+1]);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }

    public static void powerSet(int maxDepth, int cnt, boolean[] isSelected ) {
        if(cnt >= maxDepth) {
            redPeople = new boolean[N+1];
            bluePeople = new boolean[N+1];
            visited = new boolean[N+1];

            setColor(isSelected);
            int redStart = getStartNum(redPeople);
            int redCount = getCount(redPeople);
                if(redStart != -1 && redCount != 0 && peopleCheck(redStart, redCount, redPeople)) {
//                    System.out.println("redCount = " + redCount);
                    int blueStart = getStartNum(bluePeople);
                    int blueCount = getCount(bluePeople);
                    if(blueStart != -1 && blueCount != 0 && peopleCheck(blueStart, blueCount, bluePeople)) {
//                        System.out.println("redCount : " + redCount + ", blueCount = " + blueCount);
                        int redPop= getPopulation(redPeople, people);
                        int bluePop= getPopulation(bluePeople, people);
                        min = Math.min(Math.abs(redPop - bluePop), min);
                    }
                }
            return;
        }

        isSelected[cnt] = true;
        powerSet(N, cnt+1, isSelected);
        isSelected[cnt] = false;
        powerSet(N, cnt+1, isSelected);

    }

    private static int getCount(boolean[] isSelect) {
        int cnt =0;
        for(int i = 1; i<= N; i++){
            if(isSelect[i]){
                cnt++;
            }
        }
        return cnt;
    }

    public static int getPopulation(boolean[] people, int[] population) {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            if(people[i]){
                sum += population[i];
            }
        }
        return sum;
    }

    public static boolean peopleCheck(int start, int count, boolean[] people) {
        visited[start] = true;
        int cnt = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int node : cities[now]) {
                if(!visited[node] && people[node]){
                    visited[node] = true;
                    queue.offer(node);
                    cnt++;
                }
            }
        }

        if(cnt >= count) return true;
        return false;
    }
    public static void setColor(boolean[] isSelect) {
        for(int i = 1; i <= N; i++){
            if(isSelect[i]) redPeople[i] = true;
            else bluePeople[i] = true;
        }
    }

    public static int getStartNum(boolean[] isSelect) {
       for(int i = 1; i <=N; i++) if(isSelect[i]) return i;
       return -1;
    }
}


