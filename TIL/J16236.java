package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
 finish()
 먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.

 먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
 if(크기 <= 상어) 우선순위(거리)
 거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
 각 물고기와 상어와의 관계(스케닝)
 거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
 이건 모르겠는데 일단 위부터

 조건 -> 먹을때마다 크기처럼 먹는다면 몸집 +1
 */
class Fish implements Comparable<Fish>{
    int posX;
    int posY;

    int size;
    int dist;
    int state;

    public Fish(int posX, int posY, int size, int dist) {
        this.posX = posX;
        this.posY = posY;
        this.size = size;
        this.dist = dist;
        state = 1;
    }

    @Override
    public int compareTo(Fish fish) {
        return this.dist - fish.dist;
    }
}

public class J16236 {
    static int N, map[][], eat, sharkX, sharkY, ans;
    static int state = 2;
    static ArrayList<Fish> list;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        list = new ArrayList<>();
        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            for(int j = 0 ; j < N; j++){
                int v = Integer.parseInt(input[j]);
                if(v == 9){
                    map[i][j] = 0;
                    sharkX = i; sharkY = j;
                }else {
                    map[i][j] = v;
                    list.add(new Fish(i,j,v,0));
                }
            }
        }

        while(true){
            scanning();
            eat();
        }
    }
    public static void eat() {
        boolean meal = false;
        PriorityQueue<Fish> queue = new PriorityQueue<>();
        for (Fish fish : list) {
            if(fish.state == 0 || fish.dist == 0 || fish.size > state) continue;
            queue.offer(fish);
        }
        if(!queue.isEmpty()){
            Fish fish = queue.poll();
            fish.state = 0;
            eat++;
            if(eat == state){
                state++;
                eat = 0;
            }
            sharkX = fish.posX;
            sharkY = fish.posY;
            meal = true;
            ans += fish.dist;
        }
        if(!meal) {
            System.out.println(ans);
        }

    }
    public static void scanning(){
        for (Fish fish : list) {
            if(state < fish.size) continue;
            boolean[][] visited = new boolean[N][N];
            PriorityQueue<int[]> queue = new PriorityQueue<>();
            queue.offer(new int[]{fish.posX, fish.posY, fish.size, 0});
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int cx = cur[0]; int cy = cur[1]; int cdist = cur[3];
                if(cx == sharkX && cy == sharkY) {
                    fish.dist = cdist;
                    break;
                }
                for(int i =0; i< 4; i++){
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(isIn(nx, ny) && map[nx][ny] == 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, cdist+1});

                    }
                }
            }
        }
    }

    public static boolean isIn(int x,int y){
        return x >=0 && y >= 0 && x< N && y<N;
    }
}
