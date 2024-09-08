package TIL;

import java.io.*;
import java.util.*;

/*
상근이는 건물에 갇힘
건물의 일부는 불났고 상근이는 출구를 향해 뛰고 있다.

매 초마다, 불은 동서남북(4방위) 방향을 입전한 빈 공간으로 퍼져 나간다.
벽에는 불이 붙지 않음

상근이도 사방위 이동 가능 1초가 걸림
벽 뚫 ㄴㄴ이고 불이 옮겨진 칸 또는 이제 불이 붙으려는 칸으로 이동 ㄴㄴ임
상근이는 칸에 옮겨옴과 동시에 달느 칸으로 이동 가능

빌딩의 지도가 주어졌을때 얼마나 빨리 빌딩을 탈출할 수 있는가?

[입력]

. 빈공간
# 벽
@ 상근이
* 불

IMPOSSIBLE

 */
public class J5427 {
    static int R, C, dogX, dogY, ans;
    static Queue<int[]> fire;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] map;
    static boolean[][] visited, fireVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while (T > t) {
            String[] input = buffer.readLine().split(" ");
            C = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            fire = new LinkedList<>();
            map = new char[R][C];
            visited = new boolean[R][C];
            fireVisited = new boolean[R][C];

            for (int i = 0; i < R; i++) {
                String str = buffer.readLine();
                map[i] = str.toCharArray();
            }
            //입력 완료

            findObject();

            ans = exit();
            System.out.println(ans == -1 ? "IMPOSSIBLE" : ans);
            t++;
        }
    }

    private static int exit() {
        int time = 0;
        Queue<int[]> queue = new LinkedList<>();
        visited[dogX][dogY] = true;
        queue.offer(new int[]{dogX, dogY});

        while (!queue.isEmpty()) {
            int fireTime = fire.size();
            for (int t = 0; t < fireTime; t++) {
                int[] dir = fire.poll();
                int x = dir[0];
                int y = dir[1];

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (isIn(nx, ny) && map[nx][ny] == '.' && !fireVisited[nx][ny]) {
                        fireVisited[nx][ny] = true;
                        fire.offer(new int[]{nx, ny});
                    }
                }
            }

            int dogTime = queue.size();
            for (int t = 0; t < dogTime; t++) {
                int[] dir = queue.poll();
                int x = dir[0];
                int y = dir[1];
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if (!isIn(nx, ny)) {
                        return time + 1;
                    } else if (isIn(nx, ny) && !visited[nx][ny] && !fireVisited[nx][ny]) {
                        if (map[nx][ny] == '.') {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
            time++;
        }
        return -1;
    }


    public static void findObject() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '@') {
                    dogX = i;
                    dogY = j;
                } else if (map[i][j] == '*') {
                    fire.offer(new int[]{i, j});
                }
            }
        }
    }

    public static boolean isIn(int x, int y) {
        if (x >= 0 && y >= 0 && x < R && y < C) return true;
        return false;
    }
}
