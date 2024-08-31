package TIL;


/*
N x N
바구니에 저장할 수 있느 ㄴ물의 양에는 제한이 없다.
좌측 상단은 (1,1)
우측 하단 (N,N)

N M 인덱스 개수, 이동 명령

비바라기를 시전하면 (N, 1), (N, 2), (N-1, 1), (N-1, 2)에 비구름이 생긴다.
5 4 // N, M
0 0 1 0 2 맵
2 3 2 1 0
4 3 2 9 0
1 0 2 9 0
8 8 2 1 0
1 3 // 이동 개수
3 4  // d(방향) s(이동 칸)
8 1
4 8

 */


import java.io.*;
import java.util.*;

public class J21610 {

    static int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1};
//    좌 상 우 하 : 0 2 4 6
//    좌상 상우 우하 좌하 : 1 3 5 7

    static int[] dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    static int[][] map;
    static int n;
    static int xR1;
    static int xR2;
    static int xR3;
    static int xR4;
    static int yR1;
    static int yR2;
    static int yR3;
    static int yR4;
    static int s;
    static int d;

    static boolean[][] visited;
    static ArrayList<int[]>[] cloud;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        map = new int[n][n];


        for (int i = 0; i < n; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }


        visited = new boolean[n][n];
        input = buffer.readLine().split(" ");
        d = Integer.parseInt(input[0]) - 1;
        s = Integer.parseInt(input[1]);

        cloudInit(); //초반 좌표 초기화
        for (int i = 0; i < s; i++) {
            xR1 = cloudX(d, xR1); // 구름 이동
            yR1 = cloudY(d, yR1); // 구름 이동
            xR2 = cloudX(d, xR2); // 구름 이동
            yR2 = cloudY(d, yR2); // 구름 이동
            xR3 = cloudX(d, xR3); // 구름 이동
            yR3 = cloudY(d, yR3); // 구름 이동
            xR4 = cloudX(d, xR4); // 구름 이동
            yR4 = cloudY(d, yR4); // 구름 이동
        }
        // 비 내림
        map[xR1][yR1]++;
        map[xR2][yR2]++;
        map[xR3][yR3]++;
        map[xR4][yR4]++;

        // 대각선 물 증가
        waterUp(xR1, yR1);
        waterUp(xR2, yR2);
        waterUp(xR3, yR3);
        waterUp(xR4, yR4);

        // 구름 마지막 경로 저장
        visited[xR1][yR1] = true;
        visited[xR2][yR2] = true;
        visited[xR3][yR3] = true;
        visited[xR4][yR4] = true;

        //arrlist로 동적 구현



        int t = 1;
        while (e > t) {
            cloud = new ArrayList[n*n];
            for (int i = 0; i < n*n; i++) {
                cloud[i] = new ArrayList<>();
            }

            input = buffer.readLine().split(" ");
            d = Integer.parseInt(input[0]) - 1;
            s = Integer.parseInt(input[1]);

            int index = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] >= 2 && !visited[i][j]) {
                        cloud[index++].add(new int[]{i, j}); // 기존구름 칸 생성 x 2이상만 구름 생성
                        map[i][j] -= 2;
                    }
                }
            }

            visited = new boolean[n][n]; // 여기서 방문 초기화

            for (int i = 0; i < index; i++) {
                for (int j = 0; j < s; j++) {
                    int x = cloudX(d, cloud[i].get(0)[0]);
                    int y = cloudY(d, cloud[i].get(0)[1]);
                    cloud[i].set(0, new int[]{x, y});
                }
            } // 구름 다 이동

            for (int i = 0; i < index; i++) {
                int x = cloud[i].get(0)[0];
                int y = cloud[i].get(0)[1];
                map[x][y]++;
            } //비내림

            for (int i = 0; i < index; i++) {
                int x = cloud[i].get(0)[0];
                int y = cloud[i].get(0)[1];
                waterUp(x, y);
            }// 대각선 물 버그

            // 방문 배열 만들기
            for (int i = 0; i < index; i++) {
                int x = cloud[i].get(0)[0];
                int y = cloud[i].get(0)[1];
                visited[x][y] = true;
            }
            t++;
        }
        cloud = new ArrayList[n*n];
        for (int i = 0; i < n*n; i++) {
            cloud[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    map[i][j] -= 2;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i< n; i++) {
            for(int j = 0; j< n; j++) {
                sum += map[i][j];
            }
        }


        System.out.println(sum);

    }


    /**
     * @param d 이동 방향
     * @param x 구름 x 좌표
     */
    public static int cloudX(int d, int x) {
        int nx = x + dx[d];

        if (nx < 0) {
            nx = n - 1;
        }

        if (nx >= n) {
            nx = 0;
        }

        return nx;
    }

    public static int cloudY(int d, int y) {
        int ny = y + dy[d];

        if (ny < 0) {
            ny = n - 1;
        }

        if (ny >= n) {
            ny = 0;
        }
        return ny;
    }

    public static void cloudInit() {
        xR1 = n - 1;
        xR2 = n - 1;
        xR3 = n - 2;
        xR4 = n - 2;

        yR1 = 0;
        yR2 = 1;
        yR3 = 0;
        yR4 = 1;
    }

    public static void waterUp(int x, int y) {
        //대각선 확인
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i * 2 + 1];
            int ny = y + dy[i * 2 + 1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] > 0) {
                cnt++;
            }
        }
        map[x][y] += cnt;
    }

}
