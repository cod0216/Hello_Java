package TIL;

import java.util.*;
import java.io.*;


public class J2178_2 {
    static int[][] A;
    static int n;
    static int m;
    static int[] dx= new int[]{1, 0, -1, 0};
    static int[] dy= new int[]{0, 1, 0, -1};
    static boolean[][] visited;

    public static void main(String[] args)throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];

        A = new int[n][m];
        for(int i = 0; i < n; i++){
            String str = bufferedReader.readLine();
            for(int j = 0; j < m; j++){
                A[i][j] = Integer.parseInt(str.substring(j,j+1));
            }
        }

        BFS(0, 0);
        System.out.println(A[n-1][m-1]);


    }
    private static void BFS(int x, int y){
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{x,y});
        visited[x][y] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = now[0]+dx[i];
                int ny = now[1]+dy[i];
                if(nx >=0 && ny >= 0 && nx < n && ny < m){
                    if(A[nx][ny] != 0 && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        A[nx][ny] = A[now[0]][now[1]] + 1;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
        }
    }

}
