package TIL;

import java.io.*;
import java.util.*;

/*
뱀과 사다리 게임을 즐겨하는 큐브러버 ( 걍 보드 겜 좋아하는놈 인듯)

얍삽이 써서 최소 몇번만에 도착 할 수 있을까 궁굼증을 품으셨음

주사위 1~6 수 있음
게임 map 10 x 10;
1~ 100 수 적혀있음
i번 칸에 있고 주사위 4 나오면 i+4칸 이동해야됨 (현재 위치가 되는듯)
100칸 넘어가면 이동 ㄴㄴ 도착칸 사다리면 순간이동

[입력]
x, y -> x칸에 도착하면 y칸 이동

 */
public class J16928 {
    static int N, M;
    static int[] map, movingMap;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[100+1];
        movingMap = new int[100+1];
        visited = new boolean[100+1];
        Arrays.fill(map,Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            int small = Integer.parseInt(input[0]);
            int large = Integer.parseInt(input[1]);
            movingMap[small] = large;
        }

        for(int i = 0; i < M; i++){
            input = buffer.readLine().split(" ");
            int large = Integer.parseInt(input[0]);
            int small = Integer.parseInt(input[1]);
            movingMap[large] = small;
        }//입력 완료



        BFS(1);
        System.out.println(map[100]);
    }
    public static void BFS(int a){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a,0});

        while(!queue.isEmpty()){
            int[] dir = queue.poll(); int x = dir[0]; int depth = dir[1];

            for(int d = 1 ; d <=6 ; d++){
                int now = x + d;
                if(now < 101 ) {

                    if (movingMap[now] != 0 && !visited[now]) {
                        queue.add(new int[]{movingMap[now], depth + 1});
                        visited[now] =true;
                        visited[movingMap[now]] =true;
                        map[movingMap[now]] = depth + 1;
                        map[now] = depth+1;
                    } // 사다리나 뱀 자리인 경우

                    else if (movingMap[now] == 0 && !visited[now]){
                        queue.add(new int[]{now, depth + 1});
                        visited[now] =true;
                        map[now] = depth + 1;
                    } // 일반 경우

                }
            }
        }
    }
}
