package TIL;

import java.util.*;
import java.io.*;

public class J7569 {
    static int N, M, L, map[][][];
    static int[] dx = new int[]{1, 0 , -1, 0};
    static int[] dy = new int[]{0 , -1, 0, 1};
    static int[] dz = new int[]{-1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[2]);
        map = new int[L][N][M];

        // input
        for(int z = 0; z < L; z++){
            for(int i = 0; i< N; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0; j< M; j++){
                    map[z][i][j] = Integer.parseInt(input[j]);
                }
            }
        }

        // inspect
        int day = inspect();

        // result
        if(isFull()) System.out.println(day);
        else System.out.println("-1");

    }
    public static int inspect(){
        LinkedList<int[]> queue = new LinkedList<>();
        int day = 0;

        // search
        for(int z = 0; z < L; z++){
            for(int i = 0; i< N; i++){
                for(int j = 0; j< M; j++){
                    if(map[z][i][j] == 1) queue.offer(new int[]{z,i,j});
                }
            }
        }

        // modify
        while(!queue.isEmpty()){
            int size = queue.size();
            day++;

            for(int s = 0; s < size; s++){
                int[] dir = queue.poll();
                int z = dir[0];
                int x = dir[1];
                int y = dir[2];

                // x, y
                for(int d = 0; d < 4; d++){
                    int nx = x + dx[d];
                    int ny = y + dy[d];
                    if(isIn(z, nx, ny) && map[z][nx][ny] == 0){
                        map[z][nx][ny] = 1;
                        queue.offer(new int[]{z, nx, ny});
                    }
                }

                // z
                for(int d = 0; d < 2; d++){
                    int nz = z + dz[d];
                    if(isIn(nz, x, y) && map[nz][x][y] == 0){
                        map[nz][x][y] = 1;
                        queue.offer(new int[]{nz, x, y});
                    }
                }
            }
        }

        return day-1;
    }

    public static boolean isFull(){
        for(int z = 0; z < L; z++){
            for(int i = 0; i< N; i++){
                for(int j = 0; j< M; j++){
                    if(map[z][i][j] == 0) return false;
                }
            }
        }
        return true;
    }
    public static boolean isIn(int z, int x, int y){
        return z>= 0 && x >= 0 && y >= 0 && z < L && x < N && y < M;
    }
}
