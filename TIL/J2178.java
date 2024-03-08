package TIL;

import java.util.*;
import java.io.*;
public class J2178 {
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] A;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        visited = new boolean[n][m];
        A = new int[n][m];
        for(int i = 0; i < n; i++) {
            String str = bufferedReader.readLine();
            for(int j = 0; j <str.length() ; j++)
                A[i][j] = Integer.parseInt(str.substring(j,j+1));
        }

        BFS(0,0);
        System.out.println(A[n-1][m-1]);
    }

    private static void BFS(int i, int j){
        Queue<int[]> myqueue = new LinkedList<>();

        myqueue.add(new int[]{i,j});
        visited[i][j] = true;
        while(!myqueue.isEmpty()){
            int[] now = myqueue.poll();
            for(int k =0; k<4; k++){
                int x = now[0]+dx[k];
                int y = now[1]+dy[k];
                if(x >= 0 && y >= 0 && x < n && y < m)
                    if(A[x][y] != 0 && visited[x][y] != true){
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        myqueue.add(new int[]{x,y});
                    }
            }

            }

    }
}