package TIL;

import java.io.*;
import java.util.*;


public class J17141 {
    static int n, birus, map[][], birusCnt, min, emptyCnt;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static ArrayList<int[]> list;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        min = Integer.MAX_VALUE;
        n = Integer.parseInt(input[0]);
        birus = Integer.parseInt(input[1]);
        map = new int[n][n];
        list = new ArrayList<>();
        emptyCnt = 0;

        for(int i = 0 ; i< n ; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j< n ; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]== 0) emptyCnt++;
                if(map[i][j] == 2){
                    list.add(new int[] {i,j,0});
                    emptyCnt++;
                }
            }
        }
        birusCnt = list.size();

        if(emptyCnt == 0) { System.out.println(0); return;}

        combine(0, new int[birus],0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);

    }
    // 조합으로 위치 선정 - > clone 생성

    public static void combine(int num, int[] select, int cnt ){
        if(num == birus){
            ArrayList<int[]> temp = new ArrayList<>();
            for(int i = 0 ; i < birus; i++){
                temp.add(list.get(select[i]));
            }
            int time = BFS(temp);
            if(time != -1) min = Math.min(time,min);
            return;
        }
        for(int i = cnt; i < birusCnt; i++){
            select[num] = i;
            combine(num+1,select,i+1);
        }
    }

    public static int BFS(ArrayList<int[]> temp){
        Queue<int[]> queue = new LinkedList<>();
        int time = 0,count =0;
        visited = new boolean[n][n];
        //내림차순?
        for(int[] cur : temp) {
            queue.offer(cur);
            visited[cur[0]][cur[1]] = true;
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i< size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                count++;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (isIn(nx, ny) && !visited[nx][ny] && map[nx][ny] != 1) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }//pq while end

        if(count == emptyCnt) return time -1;
        return -1;
    }
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x< n && y<n;
    }

}
