//package TIL;

import java.io.*;

/*
재현이는 선거구 확정했지비
권력을 매우 부당하게 행사했지비
이름도 재현시로 바꿨지비

근디 선거에서는 공평하고 선거구를 확정하려 하지비

NxN격자로 나타낼수 있지비
각 구역은 다섯 선거구 중 하나에 포함되어야 함

선거구는 구역을 적어도 하나 포함해야됨
선거구에 포함되어 있는 구역은 모두 연결되어야함

대중 게리맨더링 1과 비슷하다함

4: x :  4 ~ 7, y : 4~7

 */


public class J17779 {
    static int N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(buffer.readLine());
        map = new int[N][N];





    }
}
