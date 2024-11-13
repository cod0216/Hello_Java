package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class J1944 {
    static int map[][], n, k, parents[];
    static ArrayList<int[]> dir;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static PriorityQueue<int[]> pq;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));

        dir = new ArrayList<>();
        map = new int[n][n];
        parents = new int[k+1];
        for (int i = 0; i <= k; i++) {
            parents[i]=i;
        }
        int index = 2;
        for (int i = 0; i < n; i++) {
            input = buffer.readLine().split("");
            for (int j = 0; j < n; j++) {
                char c = input[j].charAt(0);
                if (c == '1') map[i][j] = 1;
                else if (c == '0') map[i][j] = 0;
                else if (c == 'S') {
                    map[i][j] = -1;
                    dir.add(new int[]{i, j});
                } else if (c == 'K') {
                    map[i][j] = index++;
                    dir.add(new int[]{i, j});
                }
            }// input end
        }


        for (int i = 0; i < dir.size(); i++){
            bfs(dir.get(i),i+1);
        }
        mst();
    }
    public static void bfs(int[] c, int key){
        key -=1;
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[n][n];
        queue.offer(new int[]{c[0],c[1],0});
        visited[c[0]][c[1]] = true;
        while(!queue.isEmpty()){
            int[] cur= queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(isIn(nx,ny) && map[nx][ny] != 1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx,ny,cur[2]+1});
                    if(map[nx][ny]>0){
                        pq.offer(new int[]{key, map[nx][ny]-1, cur[2]+1});
                    }
                }
            }
        }// queue while end
    }

    static public void mst(){
        int res = 0;
        int cnt = 0;
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            // System.out.println("cur 0 : " + cur[0] + ", cur 1 : " + cur[1] + ", cur 2 : " + cur[2]);
            if(find(cur[0]) != find(cur[1])){
                union(find(cur[0]), find(cur[1]));
                res +=cur[2];
                cnt++;
                if(cnt == k) break;
            }
        }// pq while end

        System.out.println(cnt != k ? -1 : res);
    }

    static public int find(int a){
        if(parents[a] == a) return parents[a];
        return parents[a] = find(parents[a]);
    }

    static public void union(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        parents[max] = min;
    }

    public static boolean isIn(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
}