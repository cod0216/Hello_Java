package TIL.review;

import java.util.*;
import java.io.*;


public class J2178 {
    static int[][] array;
    static boolean[][] visited;
    static int[] tx = new int[]{0, 1, 0, -1};
    static int[] ty = new int[]{1, 0, -1, 0};
    static int col;
    static int row;


    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");


        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);

        visited = new boolean[row][col];

        array = new int[row][col];

        for(int i = 0; i < row; i++){
            String str = buffer.readLine();
            for(int j = 0; j < col; j++){
               array[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        BFS(0,0);

        System.out.println(array[row-1][col-1]);

    }

    private static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;


        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nx = now[0];
            int ny = now[1];
            for(int i =0; i<4; i++) {
                int dx = nx + tx[i];
                int dy = ny + ty[i];


                if (dx >= 0 && dy >= 0 && dx < row && dy < col) {
                    if (array[dx][dy] != 0 && !visited[dx][dy]) {
                        visited[dx][dy] = true;
                        queue.add(new int[]{dx,dy});
                        array[dx][dy] = array[nx][ny] + 1;
                    }
                }
            }
        }
    }
}
