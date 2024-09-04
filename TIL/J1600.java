package TIL;

import java.io.*;
import java.util.*;

/**
 * 원숭이 한 마리가 세상 구경을 하고 있다.
 * 말이 되소피어하는데 그래서 말의 움직임을 열심히 관찰했다.
 * 말은 말이다.
 * 격자판에서 체스의 나이트와 같은 이동 방식을 가진다.
 * 말은 장애물 뛰어 넘을 수 있다.
 *
 * 원숭이는 K 번만 말처럼 움직이고 그 다음에는 인접한 칸으로 움직 일 수 잇다.
 * 대각선 방향은 인접칸으로 포함되지 않는다.(4방위)
 *
 * 맨 왼쪽 위에서 시작해서 맨 오른쪽 아래깢 ㅣ가야한다.
 * 인접한 내 방향으로 한 번 움직이는 것, 말의 움직임으로 한 번 움직이는 것 모두, 한 번의 동작으로 친다.
 * 격자판이 주어졌을때 원숭이가 최소한의 동작으로 시작지점에서 도착지점까지 갈 수 있는 프로그램을 작성하시오
 *
 * [입력]
 * 첫줄에 정수 K
 * 둘째 물에 격자판 w, h 주어진다.
 * 0은 평지 1은 장애물 뜻함
 *
 * 원숭이 움직임 최솟값 출력 없으면 -1
 */

public class J1600 {

    static int W;
    static int H;
    static int[][] map;
    static boolean[][][] visited;
    static int goal = Integer.MAX_VALUE;
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int[][] hdx = new int[][]{{-1, -1},{1,1},{-1,1},{1,-1}};
    static int[][] hdy = new int[][]{{-1, 1},{-1,1},{-1,-1},{1,1}}; // 상좌 상우
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int move = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");

        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        map = new int[H][W];
        visited = new boolean[H][W][move+1];

        for(int i = 0; i < H; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j<W; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        start(0,0,move,0);
        if(goal == Integer.MAX_VALUE) goal =-1;
        System.out.println(goal);
    }

    public static void start(int x, int y, int move, int cnt){
        visited[x][y][move] = true;
        if(x == W-1 && y == H-1) {
            goal = Math.min(goal,cnt);
            return;
        }

        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(isIn(nx, ny)&& !visited[nx][ny][move]) {

                start(nx,ny,move,cnt+1);
            }
        }

        if(move >0){

            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(isIn(nx,ny)){
                    for(int j = 0 ; j < 2; j++){
                        int hx = nx + hdx[i][j];
                        int hy = ny + hdy[i][j];
                        if(isIn(hx,hy) && !visited[hx][hy][move-1]){
                            start(hx,hy,move-1,cnt+1);
                        }
                    }
                }
            }
        }
         visited[x][y][move] = false;

    }



    public static boolean isIn(int x, int y){
        if(x >= 0 && y >= 0 && x< H && y < W && map[x][y] != 1) return true;
        return false;
    }
}
