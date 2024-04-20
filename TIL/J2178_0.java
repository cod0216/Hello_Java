package TIL;

import java.io.*;
import java.util.*;

public class J2178_0 {
    static int[][] field;
    static int[] nowRow = {0, 1, 0, -1};
    static int[] nowCol = {1, 0, -1, 0};
    static int row;
    static int col;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        row = Integer.parseInt(input[0]);
        col = Integer.parseInt(input[1]);
        field = new int[row][col];
        visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            String str = buffer.readLine();
            for(int j =0; j <col; j++){
                field[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }
        BFS(0,0);
        for (int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }



    }

    private static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){

            int[] now = queue.poll();
            for(int i = 0; i < 4; i ++){
                int dx = nowRow[i] + now[0];
                int dy = nowCol[i] + now[1];
                if(dx >= 0 && dy >= 0 && dx < row && dy < col){
                    if(!visited[dx][dy] && field[dx][dy] != 0 ){
                        visited[dx][dy] = true;
                        queue.add(new int[]{dx,dy});
                        field[dx][dy] = (field[now[0]][now[1]])+1;
                    }
                }
            }
        }
    }
}
