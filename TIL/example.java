package TIL;

import java.io.*;
import java.util.*;

public class example {
    static int[] dx = {0, 1, 0, -1};//
    static int[] dy = {1, 0, -1, 0};//
    static boolean[][] visited;//
    static int[][] A;//
    static int N, M;//

    public static void main(String[] args)throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));//
        String[] input = bufferedReader.readLine().split(" ");//
        N = Integer.parseInt(input[0]);//
        M = Integer.parseInt(input[1]);//

        A = new int[N][M];//
        visited = new boolean[N][M];//
        for(int i = 0; i<N; i++){
            String line = bufferedReader.readLine();
            for(int j = 0; j<M; j++){
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);
        System.out.println(A[N-1][N-1]);
    }

    public static void BFS(int i, int j){
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i,j});
        visited[i][j] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            for(int k = 0; k <4; k++){ //상하좌우 탐색
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x >= 0 && y>=0 && x< N && y <M){ // 배열을 넘어가면 안됨
                    if(A[x][y] != 0 && !visited[x][y]) { //0이여서 갈수 없거나 기방문한 곳이면 안됨
                        //이제 갈 수 잇는곳
                        visited[x][y] = true;
                        A[x][y] = A[now[0]][now[1]] + 1; //덱스를 넣어준다 핵심!!
                        queue.add(new int[] {x,y});
                    }
                }

            }
        }
    }
}
