//
//package TIL;
//
//
//import java.util.*;
//import java.io.*;
//
//
///*
// *
// *
// * 지도에 N x M 크기의 격자로 표현이 가능함
// * 위쪽에서 i번째 줄의 왼쪽에서 j번째 칸이 물이면 W 땅이면 L로 표현된다.
// * 어떤 칸에 사람이 있으면 그 칸의 상하좌우에 있는 칸으로 이동하는 것을 반복하여 다른 칸으로 이동할 수 있다.
// * 단 격자 밖으로 나가는 이동은 불가능 하다. (isIn) 땅으로 표현된 모든 칸에 대해서, 어떤 물인 칸으로
// * 이동하기 위한 최소 이동 횟수를 구하고 모든 이동 횟수의 합을 출력하는 프로그램을 작성하라.
// *
// */
//
//public class S10966 {
//    static int minSum;
//    static char[][] map;
//    static int N;
//    static int M;
//    static boolean[][] visited;
//
//    public static void main(String[] args)throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//
//        int T = Integer.parseInt(buffer.readLine());
//        int t = 0;
//        while(T > t) {
//            String[] input = buffer.readLine().split(" ");
//
//            N = Integer.parseInt(input[0]);
//            M = Integer.parseInt(input[1]);
//
//            map =new char[N][M];
//
//            for(int i = 0 ; i < N; i ++) {
//                String str = buffer.readLine();
//                map[i] = str.toCharArray();
//            }
//
//
//            for(int i = 0; i< N; i++) {
//                for(int j = 0; j <M; j++) {
//                    visited = new boolean[N][M];
//                    if(map[i][j] != 'W') DFS(i,j);
//                }
//            }
//
//
//            t++;
//            System.out.println("#" + t + " " + minSum);
//        }
//    }
//
//    public static boolean isIn(int x, int y) {
//        if(x >= 0 && y >= 0 && x < N && y < N) return true;
//        return false;
//    }
//}
