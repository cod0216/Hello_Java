package TIL;
import java.util.*;

public class P2 {
    static LinkedList<int[]> cd;
    static int[][] originMap, waterMap, islandMap;
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[] countWater;
    static int countNum, N, M, islandNum, sum, maxValue;
    static boolean[][] visitedMap, visitedWaterMap;
    static boolean[] visited, visitedIslandMap;

    public static void main(String[] args) {
        waterMap = new int[N][M];
        visitedWaterMap = new boolean[N][M];
        visitedMap = new boolean[N][M];
        islandNum = 2;
        countWater = new int[M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sum = 0;
                if (!visitedMap[i][j] && originMap[i][j] == 1) {
                    search(i, j);
                    islandNum++;
                }
                if (!visitedWaterMap[i][j] && originMap[i][j] == 1) {
                    fillWater(i, j);
                }
            }
        }//복구 완료


        for (int i = 0; i < M; i++) {
            calWater(i);
        }

        for (int i = 0; i < M; i++) {
            findMaxValue(countWater[i]);
        }

        int answer = maxValue;

        System.out.println(answer);
    }

    public static void search(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        cd.add(new int[]{a, b});
        queue.offer(new int[]{a, b});
        visitedMap[a][b] = true;
        sum += originMap[a][b];
        islandMap[a][b] = islandNum;

        while (!queue.isEmpty()) {
            int[] dir = queue.poll();

            int x = dir[0];
            int y = dir[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isIn(nx, ny) && !visitedMap[nx][ny] && originMap[nx][ny] == 1) {
                    islandMap[nx][ny] = islandNum;
                    visitedMap[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    sum += originMap[nx][ny];
                }
            }
        }
    }

    public static void fillWater(int a, int b) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{a, b});
        visitedWaterMap[a][b] = true;
        waterMap[a][b] = sum;

        while (!queue.isEmpty()) {

            int[] dir = queue.poll();

            int x = dir[0];
            int y = dir[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (isIn(nx, ny) && !visitedWaterMap[nx][ny] && originMap[nx][ny] == 1) {
                    waterMap[nx][ny] = sum;
                    visitedWaterMap[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

    public static void findMaxValue(int value) {
        maxValue = Math.max(value, maxValue);
    }

    public static void calWater(int index) {
        int totalWater = 0;
        visitedIslandMap = new boolean[islandNum];

        for (int i = 0; i < N; i++) {
            int number = islandMap[i][index];

            if (!visitedIslandMap[number]) {
                visitedIslandMap[number] = true;
                totalWater += waterMap[i][index];
            }
        }
        countWater[index] = totalWater;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
