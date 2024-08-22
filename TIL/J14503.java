package TIL;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class J14503 {
    static int N;
    static int M;
    static int[][] arr;
    static int dir;
    static int x;
    static int y;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static boolean check;
    static boolean done;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        input = buffer.readLine().split(" ");

        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        dir = Integer.parseInt(input[2]);

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        while (true) {
            move();
            if(done()) break;
        }


        //        int a = 0;
//        int n = 4;

//        System.out.println(a % n);
//        a-=1;
//        if(a < 0){
//            a = n-1;
//        }
//z       System.out.println(a % n);
        System.out.println(cnt);

    }

    public static void move() {
        int d = dir;
        if (x >= 0 && y >= 0 && x < N && y < M && arr[x][y] == 0) {
            arr[x][y] = 1;
            cnt++;
        } else {
            check = false;
            for (int i = 0; i < 4; i++) {
                dir = (dir + 3) % 4;
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    check = true;
                    break;
                }
            }
            if (!check) {
                int backDir = (dir + 2) % 4;
                int bx = dx[backDir];
                int by = dy[backDir];
                if (bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) {
                    x = bx;
                    y = by;
                } else done = true;
            }

        }
    }



    public static boolean done() {
        for(int i = 0 ; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < M && arr[nx][ny] == 0) {
                return false;
            }
        }

        int backDir = (dir + 2) % 4;
        int bx = x + dx[backDir];
        int by = y + dy[backDir];
        if(bx >= 0 && by >= 0 && bx < N && by < M && arr[bx][by] != 1) return true;
        else return false;

    }

}
