package TIL;

/*

CCTV 1  CCTV 2   CCTV 3   CCTV 4    CCTV 5
                    |        |         |
  o->    <-o->      o->    <-o->     <-o->
                                       |
6번은 벽

CCTV는 회전 시킬 수 있다. 회전은 항상 90도 방향으로 해야한다.
감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
 */


import java.io.*;
import java.util.*;

class Cam{
    int x;
    int y;
    int type;

    public Cam(int x, int y, int type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }
}

public class J15683 {
    static int[][] map;
    static int R;
    static int C;

    static boolean[][] visited;
    static int n;
    static int max;
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1}; //상, 우, 하, 좌
    static int types[][][] = {
            {{0},{1},{2},{3}},      //1
            {{0,2},{1,3}},           //2
            {{0,1},{1,2},{2,3},{0,3}},//3
            {{0,1,2},{1,2,3},{2,3,0},{3,0,1}},//4
            {{0,1,2,3}}//5
    };

    static int stone;
    static ArrayList<Cam> camList;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        camList = new ArrayList<>();
        map = new int[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i< R; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j < C; j++){
                map[i][j]= Integer.parseInt(input[j]);
                if(map[i][j] >0 && map[i][j] < 6){
                    camList.add(new Cam(i,j,Integer.parseInt(input[j])-1));
                    stone++;
                }
                if(Integer.parseInt(input[j]) == 6){
                    stone++;
                }
            }
        }

        DFS(0,0,visited);
        System.out.println(R*C -stone -max);
    }

    /**
     *
     * @param n cam 수 까지만
     * @param sum 합
     * @param visited 방문 확인용
     */
    public static void DFS(int n, int sum, boolean[][] visited){
        if(n == camList.size()){
            max = Math.max(max, sum);
            return;
        }

        Cam cam = camList.get(n);
        for(int i = 0 ; i < types[cam.type].length; i++){
            boolean[][] copyVisited = copyArr(visited);
            int local = cal(cam, types[cam.type][i], copyVisited);
            DFS(n+1, sum+local, copyVisited);
        }
    }

    public static int cal(Cam cam, int[] d, boolean[][] visited){
        int cnt = 0;
        for(int i = 0 ; i < d.length;  i++) {
            int nx = cam.x;
            int ny = cam.y;
            while (true) {
                nx += dx[d[i]];
                ny += dy[d[i]];

                if (!isIn(nx, ny) || map[nx][ny] == 6) break;
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    cnt += 1;
                    visited[nx][ny] = true;
                }
            }
        }
        return cnt;
    }

    public static boolean isIn(int x, int y){
        if(x >= 0 && y >= 0 && x < R && y < C  ) return true;
        return false;
    } // 경계값 체크

    public static boolean[][] copyArr(boolean[][] arr){
        boolean[][] copyCheck = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            System.arraycopy(arr[i], 0, copyCheck[i], 0, arr[i].length);
        }
        return copyCheck;
    } // 배열 복사

}
