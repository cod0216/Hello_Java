package TIL;

import java.io.*;
import java.nio.Buffer;
import java.util.*;

/*
철수네 토마토 농장에서 토마토 보관용 창고가 있음

보관 후 하루 지나면 익은 토마토의 인접한 곳에 있는 익지 않은 토마토들은 요술빔 받아 익게 됨

1 익토 0 노익토 -1 노토

따악 봐도 BFS
depth로 날짜 체크

 */
public class J7576 {
    static int r, c, max, map[][];
    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static boolean no, visited[][];
    static ArrayList<int[]> list;
    public static void main(String[] args)throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        c = Integer.parseInt(input[0]);
        r = Integer.parseInt(input[1]);
        map = new int[r][c];
        visited = new boolean[r][c];
        list = new ArrayList<>();



        for(int i = 0 ; i< r; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j< c; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] ==1){
                    list.add(new int[]{i,j, 0});
                }
            }
        }//input end;

        BFS();

        if(noGoodTomato()) System.out.println("-1");
        else System.out.println(max);
    }

    public static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<list.size(); i++ ){
            queue.add(new int[]{list.get(i)[0],list.get(i)[1],0});
        }

        while(!queue.isEmpty()){
            int[] dir = queue.poll();
            int x = dir[0]; int y = dir[1]; int day = dir[2];
            for(int i = 0 ; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nDay = day+1;
                if(isIn(nx,ny)){
                    visited[nx][ny] = true;
                    max = Math.max(max, nDay);
                    queue.add(new int[]{nx,ny,nDay});
                    map[nx][ny] = nDay;
                }
            }// dx[] for end

        }// !q while end
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < r && y < c
                && map[x][y] != -1 && map[x][y] != 1 && !visited[x][y];
    }

    public static boolean noGoodTomato(){
        for(int i= 0; i< r; i++){
            for(int j= 0; j< c; j++){
                if(map[i][j] ==0){
                    return true;
                }
            }
        }
        return false;
    }
}

