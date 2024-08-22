//package TIL;
//
//import java.io.*;
//import java.util.*;
//
//
//public class J20057 {
//    static int N;
//    static int[][] map;
//    static int[][] dirX = new int[][]{
//            {-1, -1, -1, -2, 1, 1, 2, 1, 0},
//            {1, 0, -1, 0, -1, 0, 0, 1, 2},
//            {-1, -1, -1, -2, 1, 1, 2, 1, 0},
//            {1, 0, -1, 0, -1, 0, 0, 1, -2}
//    };
//    static int[][] dirY = new int[][]{
//            {-1, 0, 1, 0, 1, 0, 0, -1, -2},
//            {-1, -1, -1, -2, 1, 1, 2, 1, 0},
//            {-1, 0, 1, 0, 1, 0, 0, -1, +2},
//            {-1, -1, -1, -2, 1, 1, 2, 1, 0}
//    };
//    static int[] rate = new int[]{1, 7, 10, 2, 1, 7, 2, 10, 5};
//
//    public static void main(String[] args)throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//        N = Integer.parseInt(buffer.readLine());
//        map = new int[N][N];
//
//        int mid = N/2;
//        int print = 1;
//        int foot = -1;
//        int left = mid;
//        int bottom = mid;
//        int k=1;
//
//
//        for(int i = 0 ; i <  N; i++){
//             String[] input = buffer.readLine().split(" ");
//            for(int j = 0; j< N; j++) {
//                map[i][j] = Integer.parseInt(input[j]);
//            }
//        }
//
//        while(k<= N*N){
//            for(int j = 0 ; j < print; j++){
//                if(k> N*N) break;
//                int value = k%1;
//                map[bottom][left]/100;
//                left += foot;
//
//            }
//            foot *=-1;
//
//            for(int j= 0; j < print; j++){
//                if(k> N*N) break;
//                map[bottom][left] = k++;
//                bottom += foot;
//            }
//            print++;
//
//        }
//
//        for(int i = 0 ; i < N; i++){
//            for(int j = 0 ; j < N; j++){
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
//    public static void dust(){
//
//    }
//}
