package TIL;

/*
2
5 up
4 8 2 4 0
4 4 2 0 8
8 0 2 4 4
2 2 2 2 8
0 2 2 0 0
2 down
16 2
0 2

[접근방법]
답안 맵을 새로 만들어서 그 맵에 표현


 */
import java.io.*;
import java.util.*;

public class S6109 {
    static int N;
    static int[][] map;
    static int[][] result;


    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while (T > t) {
            String[] input = buffer.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            String dir = input[1];
            map = new int[N][N];
            result = new int[N][N];

            for (int i = 0; i < N; i++) {
                input = buffer.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            switch (dir) {
                case "up":
                    up();
//                    zeroUp();
                    break;
                case "right":
                    right();
//                    zeroRight();
                    break;
                case "down":
                    down();
//                    zeroDown();/
                    break;
                case "left":
                    left();
//                    zeroLeft();
                    break;
            }

            t++;
            System.out.println("#" + t);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    //    public static void zeroUp(){
//        for(int i = 0 ; i < N; i++){
//            for(int j = 1; j < N; j++){
//                if (map[j-1][i] == 0) {
//                    int index = 0;
//                    for(int k = j; k < N; k++){
//                        if(map[k][i] != 0){
//                            index = k;
//                            break;
//                        }
//                        index = N-1;
//                    }
//                    map[j-1][i] = map[index][i];
//                    map[index][i] = 0;
//                }
//            }
//        }
//    }
//
//    public static void zeroDown(){
//        for(int i = 0 ; i < N; i++){
//            for(int j = 0; j < N-1; j++){
//                int index = 0;
//                if (map[j+1][i] == 0) {
//                    for(int k =j+1; k < N; k++) {
//                        if(map[k][i] != 0){
//                            index = k-1;
//                            break;
//                        }
//                    }
//                    map[index][i] = map[j][i];
//                    map[j][i] = 0;
//                }
//            }
//
//        }
//    }
//    public static void zeroRight(){
//        for(int i = 0 ; i < N; i++){
//            for(int j = 0; j < N-1; j++){
//                int index = 0;
//                if (map[i][j+1] == 0) {
//                    for(int k=j+1; k<N; k++){
//                        if (map[i][k] !=0) {
//                            index = k-1;
//                            break;
//                        }
//                    }
//                    map[i][index] = map[i][j];
//                    map[i][j] = 0;
//                }
//            }
//        }
//    }
//    public static void zeroLeft(){
//        for(int i = N-1 ; i >= 0; i --) {
//            for (int j = N-1; j > 0; j--) {
//                int index=0;
//                if (map[j-1][i] == 0) {
//                    for(int k = j-1; k > 0 ;k--){
//                        if(map[k][i] !=0){
//                            index = k-1;
//                        }
//                    }
//                    map[index][i] = map[j][i];
//                    map[j][i] = 0;
//                }
//            }
//        }
//    }
    public static void up() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == 0) continue;
                int idx = j + 1;

                while (map[idx][i] == 0) {
                    if (idx == N - 1) break;
                    idx++;
                }

                if (map[idx][i] == 0) continue;

                if (map[j][i] == map[idx][i]) {
                    map[j][i] += map[idx][i];
                    map[idx][i] = 0;
                    j = idx;
                }
            }
            int cur = 0;
            for (int j = 0; j < N; ++j) {
                if (map[j][i] != 0) {
                    result[cur++][i] = map[j][i];
                }
            }
        }
    }

    public static void right() {
        for (int i = 0; i < N; ++i) {
            for (int j = N - 1; j > 0; j--) {
                if (map[i][j] == 0) {
                    continue;
                }

                int idx = j - 1;

                while (map[i][idx] == 0) {
                    if (idx == 0) {
                        break;
                    }

                    idx--;
                }

                if (map[i][idx] == 0) {
                    continue;
                }

                if (map[i][j] == map[i][idx]) {
                    map[i][j] += map[i][idx];
                    map[i][idx] = 0;
                    j = idx;
                }
            }

            int cur = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    result[i][cur--] = map[i][j];
                }
            }
        }
    }

    public static void down() {
        for (int i = 0; i < N; i++) {

            for (int j = N - 1; j > 0; j--) {

                if (map[j][i] == 0) continue;

                int idx = j - 1;

                while (map[idx][i] == 0) {
                    if (idx == 0) break;
                    idx--;
                }
                if (map[idx][i] == 0) continue;

                if (map[j][i] == map[idx][i]) {
                    map[j][i] += map[idx][i];
                    map[idx][i] = 0;
                    j = idx;
                }

            }
            int cur = N - 1;
            for (int j = N - 1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    result[cur--][i] = map[j][i];
                }
            }
        }
    }

    public static void left() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 0) continue;
                int idx = j + 1;
                while (map[i][idx] == 0) {
                    if (idx == N - 1) break;
                    idx++;
                }

                if (map[i][idx] == 0) continue;
                if (map[i][j] == map[i][idx]) {
                    map[i][j] += map[i][idx];
                    map[i][idx] = 0;
                    j = idx;
                }
            }

            int cur = 0;
            for (int j = 0; j < N; ++j) {
                if (map[i][j] != 0) {
                    result[i][cur++] = map[i][j];
                }
            }
        }

    }
}